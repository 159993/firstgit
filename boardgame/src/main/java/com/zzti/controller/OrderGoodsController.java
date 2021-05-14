package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import com.zzti.pojo.OrderGoods;
import com.zzti.pojo.SysResult;
import com.zzti.serviceImpl.OrderGoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ordGoods")
public class OrderGoodsController {

    @Autowired
    private OrderGoodsServiceImpl orderGoodsService;


    @ResponseBody
    @RequestMapping("/selectList")
    public String selectList(Integer page, int limit, HttpServletRequest request,
                             @RequestParam(name = "visiterName",required =  false ,defaultValue = "") String visiterName,
                             @RequestParam(name = "goodsName",required =  false ,defaultValue = "") String goodsName
    ){

        Map<String, Object> ret = new HashMap<>();
        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("visiterName",visiterName);
        queryMap.put("goodsName",goodsName);
        List<OrderGoods> aaa = orderGoodsService.selectList(queryMap);
        queryMap.put("page",(page-1)*limit);
        queryMap.put("limit",limit);
        System.out.println(visiterName);
        List<OrderGoods> all = orderGoodsService.selectList(queryMap);



        System.out.println(all);
        String s = JSON.toJSONString(all);

        return "{\"count\":"+ aaa.size()+", \"code\":0 , \"data\":"+s+"}";

    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public SysResult deleteById(@PathVariable("id") Integer[] ids){
        System.out.println(ids);

        if(orderGoodsService.deleteByIds(ids)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }


}
