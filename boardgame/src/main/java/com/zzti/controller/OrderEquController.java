package com.zzti.controller;

import com.zzti.serviceImpl.OrderEquServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping()
public class OrderEquController {
    @Autowired
    private OrderEquServerImpl orderEquServer;

    @RequestMapping("/test1")
    @ResponseBody
    public String test1(){
    orderEquServer.selectByTime();
    return null;
    }
}
