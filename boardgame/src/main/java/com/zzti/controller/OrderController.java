package com.zzti.controller;

import com.alibaba.fastjson.JSONArray;
import com.zzti.serviceImpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private OrderServiceImpl orderService;
    @RequestMapping("/iconThree")
    @ResponseBody
    public String iconthree() {

//        List<Map<String, Integer>> goods = orderService.selectGoodsCost();
//
//        List<Map<String, Integer>> equ = orderService.selectEquCost();
//
//        List<Map<String, Integer>> visi = orderService.selectVisiterCost();

//        Map<String, Integer> goodsCost = new HashMap<>(getkv(goods));
//        Map<String, Integer> equCost = new HashMap<>(getkv(equ));
//        Map<String, Integer> visiCost = new HashMap<>(getkv(visi));

        JSONArray jsonArray = new JSONArray();


        jsonArray.add(orderService.selectEquCost());
        jsonArray.add(orderService.selectGoodsCost());
        jsonArray.add(orderService.selectVisiterCost());

        String result2=jsonArray.toJSONString();

        return result2;
    }
    @RequestMapping("/iconSix")
    @ResponseBody
    public String iconSix() {
        List<Map<String, Integer>> maps = orderService.selectThisYear();
        List<Map<String, Integer>> mapsl = orderService.selectLastYear();

        System.out.println(maps);


        Integer [] s1 = {new Date().getYear()+1900,new Date().getYear()-1+1900};
        Integer [] s2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Integer [] s3 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};


        Map<String, Integer> genderCount = new HashMap<>();
        for (Map<String, Integer> kv : maps) {
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
        Map<String, Integer> genderCountl = new HashMap<>();
        for (Map<String, Integer> kv : mapsl) {
            String key = null;
            Integer value = null;
            for (Map.Entry<String, Integer> entry : kv.entrySet()) {
                if (entry.getKey().equals("key")) {
                    key = String.valueOf(entry.getValue());
                } else {
                    value = entry.getValue();
                }
            }
            genderCountl.put(key, value);
        }

        //        Map<String, Integer> getkv = getkv(maps);
        Set<String> strings = genderCount.keySet();
        Set<String> stringsl = genderCountl.keySet();
        System.out.println(genderCountl);
        for (String sa :strings){
            s2[Integer.valueOf(sa)] = genderCount.get(sa);
        }
        for (String s :stringsl){
            s3[Integer.valueOf(s)] = genderCountl.get(s);
        }

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(s1);
        jsonArray.add(s2);
        jsonArray.add(s3);

        String result2=jsonArray.toJSONString();
        System.out.println(result2);
        return result2;
    }
}
