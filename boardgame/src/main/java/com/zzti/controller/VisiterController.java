package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import com.zzti.pojo.SysResult;
import com.zzti.pojo.Visiter;
import com.zzti.pojo.Waiter;
import com.zzti.serviceImpl.VisiterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/visiter/")
public class VisiterController {
    @Autowired
    private VisiterServiceImpl visiterServiceImpl;

    //访客查看自身或他人信息,根据参数id来查找个人信息,返回一个Visiter对象
    @RequestMapping("findOne")
    @ResponseBody
    public Visiter findOne(Integer id){
        return visiterServiceImpl.findOne(id);
}
    //管理员或服务员查看所有的访客信息，无参数，返回一个包含所有Visiter对象的列表
    @RequestMapping("findAll")
    @ResponseBody
    public String findAll(Integer page, int limit, HttpServletRequest request,
                                 @RequestParam(name = "visitName",required =  false ,defaultValue = "") String roleName){
//        List<Visiter> ls = visiterServiceImpl.findAll();
//        for (Visiter vs:ls
//             ) {
//            System.out.println(vs.toString());
//        }
//        return null;
        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("roleName",roleName);
        queryMap.put("page",page);
        queryMap.put("pageSize",limit);
        List<Visiter> all = visiterServiceImpl.findAll(queryMap);
        String s = JSON.toJSONString(all);
        return s;
    }
    @RequestMapping("delete")
    @ResponseBody
    //管理员或服务员删除访客信息，参数id数组，返回对象SysResult.status=200则表示成功
    public SysResult deleteById(Integer[] ids){
//        Integer[] in = new Integer[2];
//        in[0]=1;
//        in[1]=2;
//        System.out.println(visiterServiceImpl.deleteByIds(in));
//        return null;
        if(visiterServiceImpl.deleteByIds(ids)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
    @RequestMapping("add")
    @ResponseBody
    //用户注册时调用,参数Visiter对象，返回值大于0则成功
    public SysResult add(Visiter vs){
//        Visiter vs1=new Visiter(4, "qwe", "www", "zxc", "qwe", "sdfsf", 12, 1, 0, null, null);
//        System.out.println(visiterServiceImpl.add(vs1));
//        return null;
        if(visiterServiceImpl.add(vs)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
    @RequestMapping("update")
    @ResponseBody
    //用户修改信息时调用,参数Visiter对象，返回值大于0则成功
    public SysResult update(Visiter vs){
//        Visiter vs1=new Visiter(4, "qweqwe", "www", "zxc", "qwe", "sdfsf", 12, 1, 0, null, null);
//        System.out.println(visiterServiceImpl.update(vs1));
//        return null;
        if(visiterServiceImpl.update(vs)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
    @GetMapping("index")
    public String index() {
        return "index";
    }
}
