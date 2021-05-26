package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import com.zzti.pojo.SysResult;
import com.zzti.pojo.Visiter;
import com.zzti.pojo.Waiter;
import com.zzti.serviceImpl.VisiterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/visiter")
public class VisiterController {
    @Autowired
    private VisiterServiceImpl visiterServiceImpl;

    //访客查看自身或他人信息,根据参数id来查找个人信息,返回一个Visiter对象
    @RequestMapping("/findOne/{id}")
    public String findOne(@PathVariable("id") Integer id, Model model){
        Visiter one = visiterServiceImpl.findOne(id);
        model.addAttribute("visiter",one);
        return "view/user/user-form.html";
}
    //管理员或服务员查看所有的访客信息，无参数，返回一个包含所有Visiter对象的列表
    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(Integer page, int limit, HttpServletRequest request,
                                 @RequestParam(name = "visiterName",required =  false ,defaultValue = "") String visiterName
                                ,@RequestParam(name = "account",required =  false ,defaultValue = "") String account){

        Map<String, Object> queryMap = new HashMap<>();

        queryMap.put("visiterName",visiterName);
        queryMap.put("account",account);
        List<Visiter> aaa = visiterServiceImpl.findAll(queryMap);
        queryMap.put("page",(page-1)*limit);
        queryMap.put("limit",limit);
        List<Visiter> all = visiterServiceImpl.findAll(queryMap);
        System.out.println(all.toString());
        String s = JSON.toJSONString(all);
        System.out.println(s);
        return  "{\"count\":"+ aaa.size()+", \"code\":0 , \"data\":"+s+"}";

    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    //管理员或服务员删除访客信息，参数id数组，返回对象SysResult.status=200则表示成功
    public SysResult deleteById(@PathVariable("id")Integer[] ids){
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
    @RequestMapping("/add")
    @ResponseBody
    //用户注册时调用,参数Visiter对象，返回值大于0则成功
    public SysResult add(String name,String account,String password,Integer sex){
        Visiter vs1=new Visiter(null, name, account, password, null, null,
                -1, sex, 0,null, null);
//        System.out.println(visiterServiceImpl.add(vs1));
//        return null;
        System.out.println(vs1);
        if(visiterServiceImpl.add(vs1)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
    @RequestMapping("/update")
    @ResponseBody
    //用户修改信息时调用,参数Visiter对象，返回值大于0则成功
    public SysResult update(Visiter vs){
        Visiter vs1=new Visiter(vs.getId(), vs.getName(), vs.getAccount(), vs.getPassword()
                ,null, null, vs.getAge(), vs.getSex(), 1
                , null, null);
        System.out.println(visiterServiceImpl.update(vs1));
//        return null;
        if(visiterServiceImpl.update(vs1)>0)
            return SysResult.success();
        else
            return SysResult.fail();
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
