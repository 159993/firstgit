package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzti.serviceImpl.OrderEquServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class demo {
    @GetMapping("/" )
    public String index() {
        return "redirect:login.html";
    }



    @RequestMapping("/index1")
    public String index1() {
        return "redirect:website.html";
    }
//    @GetMapping("/test1")
//    @ResponseBody
//    public String qweaas(){
//        List ls1 = new ArrayList();
//        List ls2 = new LinkedList();
//
//        List all = new ArrayList();
//        for (int i = 0; i <5 ; i++) {
//            ls1.add(i,i+1);
//        }
//        for (int i = 0; i < 11; i++) {
//            ls2.add(i,Math.random()*1000-1);
//        }
//        all.add(ls1);
//        all.add(ls2);

//        JSONArray objects = new JSONArray();
//        objects.add(ls1);
//        objects.add(ls2);
//        String s = JSON.toJSONString(objects);
//        System.out.println(s);
//        String result2 = JSON.toJSONString(all);
//        System.out.println(result2);
//        return result2;
//    }

    @GetMapping("/test2")
    @ResponseBody
    public String aaaas() {
        List ls1 = new ArrayList();
        List ls2 = new LinkedList();

        List all = new ArrayList();
        for (int i = 0; i < 5; i++) {
            ls1.add(i, i + 1);
        }
        for (int i = 0; i < 11; i++) {
            ls2.add(i, Math.random() * 1000 - 1);
        }
        all.add(ls1);
        all.add(ls2);

//        JSONArray objects = new JSONArray();
//        objects.add(ls1);
//        objects.add(ls2);
//        String s = JSON.toJSONString(objects);
//        System.out.println(s);
        String result2 = JSON.toJSONString(all);
        System.out.println(result2);
        return result2;
    }
    //俺家帅哥的环境噶圣诞节嘎斯
    @Autowired
    private OrderEquServiceImpl orderEquService;

    @RequestMapping("/tusan")
    @ResponseBody
    public String aaa(){
//        Map<String,Object> m1 = new HashMap<String, Object>();
//        Map<String,Object> m2 = new HashMap<String, Object>();
//        m1.put("value",10);
//        m2.put("value",20);
//        m1.put("key","aaa");
//        m2.put("key","asd");
//        List<Map<String,Object>> lm = new LinkedList<>();
//        lm.add(m1);
//        lm.add(m2);
//        String s = JSON.toJSONString(lm);
//        System.out.println(s);


        List<Map<String, Integer>> oemap = orderEquService.contOneMonthEqu();
        String s = JSON.toJSONString(oemap);
        System.out.println(s);
        return s;


    }


}
