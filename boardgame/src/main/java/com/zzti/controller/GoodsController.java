package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import com.zzti.pojo.Goods;
import com.zzti.pojo.SysResult;
import com.zzti.serviceImpl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsServiceImpl;

    //游客，管理员，服务员查看单个商品信息，根据参数id来查找商品信息，返回有个Goods对象

    @RequestMapping("/findOneGoods")
    @ResponseBody
    public Goods findOneGoods(Integer id){
        return goodsServiceImpl.findOneGoods(id);
    }
    //游客，管理员，服务员查看所有商品信息，无参数，返回有个Goods列表
    @RequestMapping("/findById/{id}")

    public String findById(@PathVariable("id") Integer id, Model model){
        Goods good = goodsServiceImpl.findOneGoods(id);

        model.addAttribute("good",good);

        return "view/goods/goods-form.html";
    }
    //游客，管理员，服务员查看所有商品信息，无参数，返回有个Goods列表

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(){
        List<Goods> all = goodsServiceImpl.findAll();
        String s = JSON.toJSONString(all);
        return  "{\"count\":"+ all.size()+", \"code\":0 , \"data\":"+s+"}";
    }

    //管理员或服务员删除商品信息，参数id数组，返回对象SysResult.status=200则表示成功
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public SysResult deleteById(@PathVariable("id") Integer[] ids){

        if(goodsServiceImpl.deleteByIds(ids)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
    //管理员或者服务员注册时调用,参数Goods对象，返回值大于0则成功
    @RequestMapping("/add")
    @ResponseBody

    public SysResult add(Goods goods){
        Goods goods1= new Goods(null,goods.getName(),goods.getSellPrice()
                ,goods.getPurPrice(),goods.getNumber(),goods.getType());
        System.out.println(goods1.toString());
         if(goodsServiceImpl.add(goods1)>0)
             return SysResult.success();
         else
             return SysResult.fail();
    }

    //管理员或者服务员修改信息时调用,参数Goods对象，返回值大于0则成功
    @RequestMapping("/update")
    @ResponseBody
    public SysResult update(Goods goods){
        Goods goods1= new Goods(goods.getId(),goods.getName(),goods.getSellPrice(),
                goods.getPurPrice(), goods.getNumber(),goods.getType());
        System.out.println(goods1);
        if (goodsServiceImpl.update(goods1)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }

}
