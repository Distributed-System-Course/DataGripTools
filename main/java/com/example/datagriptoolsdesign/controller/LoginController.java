package com.example.datagriptoolsdesign.controller;

import com.example.datagriptoolsdesign.bean.UserBean;
import com.example.datagriptoolsdesign.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class LoginController {
    //将service注入web层
    @Resource
    UserService userService;
    //映射到web页面loginView.html
    @RequestMapping("/loginView")
    public String show(){
        return "loginView";
    }
    //映射到service层的logIn方法
    @RequestMapping(value = "/logIn",method = RequestMethod.POST)
    public String loginMethod(String name,String password){
        UserBean userBean = userService.logIn(name,password);
        if (userBean!=null)
            return "success";
        else
            return "error";
    }
}

