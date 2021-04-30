package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Controller
public class demo {
    @GetMapping("/" )
    public String index() {
        return "redirect:login.html";
    }
//    @GetMapping("/test1")
    @ResponseBody
    public String qweaas(){
        List ls1 = new ArrayList();
        List ls2 = new LinkedList();

        List all = new ArrayList();
        for (int i = 0; i <5 ; i++) {
            ls1.add(i,i+1);
        }
        for (int i = 0; i < 11; i++) {
            ls2.add(i,Math.random()*1000-1);
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
}
