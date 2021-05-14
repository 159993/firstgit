package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzti.pojo.Goods;
import com.zzti.pojo.OrderEqu;
import com.zzti.serviceImpl.OrderEquServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/ordEqu")
public class OrderEquController {
    @Autowired
    private OrderEquServiceImpl orderEquService;

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(){
    orderEquService.selectByTime();
    return null;
    }
    @GetMapping("/selectByTime")
    @ResponseBody
    public String selectByTime(){
        int[] arr1 = new int[12];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i]=i*2;
        }
        int[] arr2=orderEquService.selectByTime();

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(arr1);
        jsonArray.add(arr2);
        System.out.println(jsonArray);
        String result2=jsonArray.toJSONString();
        return result2;
    }
    @GetMapping("/contOneMonthEqu")
    @ResponseBody
    public String contOneMonthEqu(){

        List<Map<String, Integer>> oemap = orderEquService.contOneMonthEqu();

        System.out.println(oemap);
        String [] s1 = new String [5];
        Integer [] s2 = new Integer [5];
//        Integer [] i = new Integer[size];


        Map<String, Integer> genderCount = new HashMap<>();
        for (Map<String, Integer> kv : oemap) {
            String key = null;
            Integer value = null;

            for (Map.Entry<String, Integer> entry : kv.entrySet()) {
                if (entry.getKey().equals("key")) {
                    key = String.valueOf(entry.getValue());
                } else {
                    value = entry.getValue();
                }
            }
            genderCount.put(key, value);
        }
        System.out.println(genderCount);



        int con =0;

        Set<String> strings = genderCount.keySet();

        System.out.println(strings);
        for (String sa :strings ){
            s1[con] = sa;
            s2[con] = genderCount.get(sa);
            con++;
        }

        JSONArray jsonArray = new JSONArray();


        jsonArray.add(s1);
        jsonArray.add(s2);

        System.out.println(jsonArray);
        String result2=jsonArray.toJSONString();
        return result2;
    }
    @ResponseBody
    @RequestMapping("/selectAll")
    public String selectAll(){

        List<OrderEqu> all = orderEquService.slectAll();

        String s = JSON.toJSONString(all);

        return "{\"count\":"+ all.size()+", \"code\":0 , \"data\":"+s+"}";

    }
    @ResponseBody
    @RequestMapping("/selectList")
    public String selectList(Integer page, int limit, HttpServletRequest request,
                             @RequestParam(name = "visiterName",required =  false ,defaultValue = "") String visiterName,
                             @RequestParam(name = "equName",required =  false ,defaultValue = "") String equName,
                             @RequestParam(name = "damage",required =  false ,defaultValue = "") String damage
                             ){

        Map<String, Object> ret = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("visiterName",visiterName);
        queryMap.put("equName",equName);
        System.out.println("qqqq"+damage.equals(""));
        System.out.println("wwww"+damage.equals(null));
        if (damage.equals("")) {
            damage = null;
        }
        queryMap.put("damage",damage);
//        System.out.println(queryMap.get("damage").toString());
        System.out.println("aaaaaa"+damage);
        List<OrderEqu> aaa = orderEquService.slectList(queryMap);

        queryMap.put("page",(page-1)*limit);
        queryMap.put("limit",limit);
        System.out.println(visiterName);
        List<OrderEqu> all = orderEquService.slectList(queryMap);

        System.out.println(all);
        String s = JSON.toJSONString(all);
        System.out.println(s);
        return "{\"count\":"+ aaa.size()+", \"code\":0 , \"data\":"+s+"}";

    }

    @RequestMapping("/upDamage/{id},{state}")
    @ResponseBody
    public String upDamage(@PathVariable("id") String id,@PathVariable("state") String state){

        Map<String, Object> res = new HashMap();
        if(state.equals("1")) {
            Integer orde = orderEquService.updateState(id);
            System.out.println(orde);
            if (orde == 1)
                return "{status:200}";
            return "{status: -1}";
        }else
            return  "{status: -1}";
    }


}
