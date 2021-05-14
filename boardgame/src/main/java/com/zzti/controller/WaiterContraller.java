package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.zzti.pojo.SysResult;
import com.zzti.pojo.Waiter;
import com.zzti.serviceImpl.WaiterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/waiter")
public class WaiterContraller {

    @Autowired
    private WaiterServiceImpl waiterServiceImpl;


    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(Integer page, int limit, HttpServletRequest request,
                          @RequestParam(name = "roleName",required =  false ,defaultValue = "") String roleName){
        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("roleName",roleName);
        List<Waiter> aaa = waiterServiceImpl.findAll(queryMap);
        queryMap.put("page",(page-1)*limit);
        queryMap.put("limit",limit);
        List<Waiter> all = waiterServiceImpl.findAll(queryMap);
        String s = JSON.toJSONString(all);

        return "{\"count\":"+ aaa.size()+", \"code\":0 , \"data\":"+s+"}";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public SysResult insert(Waiter waiter){

        Waiter wait = new Waiter(null, waiter.getAccount(),waiter.getName(), waiter.getAge(), waiter.getSex(), null, null, null, waiter.getAddress(),
                waiter.getPhone(), waiter.getSalary(), null, waiter.getPassword());

        Integer add = waiterServiceImpl.add(wait);
        if(add>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
    @RequestMapping("/update")
    @ResponseBody
    public String update(Waiter waiter){

        Waiter wait = new Waiter(waiter.getId(),waiter.getAccount(), waiter.getName(), waiter.getAge(), waiter.getSex(), null, null, null, waiter.getAddress(),
                waiter.getPhone(), waiter.getSalary(), null, waiter.getPassword());

        Integer up = waiterServiceImpl.update(wait);
       if(up>0)
            return "1";
        else
           return "0";
    }

    @RequestMapping("/queryById/{id}")
    public String queryByid(@PathVariable("id") Integer id, Model model){

        Waiter wait = waiterServiceImpl.findOneWaiter(id);
        System.out.println(wait);
        model.addAttribute("wai",wait);

        return "view/role/role-form.html";
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public SysResult deleteById(@PathVariable("id") Integer[] ids){
        System.out.println(ids);

        if(waiterServiceImpl.deleteByIds(ids)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
}
