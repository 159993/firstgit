package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import com.zzti.pojo.OrderWaiter;
import com.zzti.serviceImpl.OrderWaiterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/orderWaiter")
public class OrderWaiterController {
    @Autowired
    private OrderWaiterServiceImpl orderWaiterService;

    @ResponseBody
    @RequestMapping("/selectList")
    public String selectList(Integer page, int limit, HttpServletRequest request,
                             @RequestParam(name = "visiterName",required =  false ,defaultValue = "") String visiterName,
                             @RequestParam(name = "waiterName",required =  false ,defaultValue = "") String waiterName
    ){

        Map<String, Object> ret = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("visiterName",visiterName);
        queryMap.put("waiterName",waiterName);
        List<OrderWaiter> aaa = orderWaiterService.selectList(queryMap);
        queryMap.put("page",(page-1)*limit);
        queryMap.put("limit",limit);
        List<OrderWaiter> all = orderWaiterService.selectList(queryMap);

        System.out.println(all);
        String s = JSON.toJSONString(all);

        return "{\"count\":"+ aaa.size()+", \"code\":0 , \"data\":"+s+"}";

    }

}
