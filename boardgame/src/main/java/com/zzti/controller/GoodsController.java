package com.zzti.controller;

import com.zzti.pojo.Goods;
import com.zzti.pojo.SysResult;
import com.zzti.serviceImpl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/findAll")
    @ResponseBody
    public List<Goods> findAll(Integer id){
        return goodsServiceImpl.findAll();
    }

    //管理员或服务员删除商品信息，参数id数组，返回对象SysResult.status=200则表示成功
    @RequestMapping("/delete")
    @ResponseBody
    public SysResult deleteById(Integer[] ids){

        if(goodsServiceImpl.deleteByIds(ids)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
    //管理员或者服务员注册时调用,参数Goods对象，返回值大于0则成功
    @RequestMapping("/add")
    @ResponseBody

    public SysResult add(Goods goods){
     if(goodsServiceImpl.add(goods)>0)
         return SysResult.success();
     else
         return SysResult.fail();
    }

    //管理员或者服务员修改信息时调用,参数Goods对象，返回值大于0则成功
    @RequestMapping("/update")
    @ResponseBody
    public SysResult update(Goods goods){
        if (goodsServiceImpl.update(goods)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }

}
