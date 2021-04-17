package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Controller
public class demo {
    @GetMapping("/index")
    public String index() {
        return "redirect:index";
    }
    @GetMapping("/test1")
    @ResponseBody
    public String qweaas(){

        List ls2 = new LinkedList();

        for (int i = 0; i < 11; i++) {
            ls2.add(i,Math.random()+i);
        }

        String result2 = JSON.toJSONString(ls2);
        return result2;
    }
}
