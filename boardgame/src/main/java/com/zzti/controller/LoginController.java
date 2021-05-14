package com.zzti.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzti.pojo.Waiter;
import com.zzti.serviceImpl.WaiterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.HashMap;


@Controller
public class LoginController {


    @Autowired
    private WaiterServiceImpl waiterServiceImpl;


    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){

        Waiter waiter = waiterServiceImpl.queryByAcc(username, password);
        if (waiter!=null){
            session.setAttribute("loginUser", username);
            return "redirect:/index.html";
        } else {
            model.addAttribute("msg", "用户名或者密码错误");
            return "login.html";
        }
    }
    @RequestMapping("/loginManager")
    public String loginManager(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){

        Waiter waiter = waiterServiceImpl.queryManager(username, password);
        if (waiter!=null){
            session.setAttribute("loginUser", username);
            return "redirect:/indexMana.html";
        } else {
            model.addAttribute("msg", "用户名或者密码错误");
            return "managerLogin.html";
        }
    }
    @RequestMapping("/login1")
    @ResponseBody
    public String login1(@RequestParam("params") String params){
        JSONObject jsonObject = (JSONObject) JSON.parse(params);

        HashMap<Object, Object> resultMap = new HashMap<>();
//        if (jsonObject.containsKey("loginUsername")){
//            String logu = jsonObject.getString("loginUsername");
//        } else {
//        resultMap.put("code", "-1");
//        }
        String loginUsername = jsonObject.getString("loginUsername");
        String loginPassword = jsonObject.getString("loginPassword");
        System.out.println(loginPassword);
        System.out.println(loginUsername);
        Waiter waiter = waiterServiceImpl.queryByAcc(loginUsername, loginPassword);
        if (waiter!=null){
            resultMap.put("code",200);
        }else resultMap.put("code",-1);
        return JSON.toJSONString(resultMap);
    }

    @RequestMapping("/logout")
    public String loginout(Model model, HttpSession session) {
        session.setAttribute("loginUser", null);
        model.addAttribute("msg", "注销成功");
        return "index.html";
    }
}

