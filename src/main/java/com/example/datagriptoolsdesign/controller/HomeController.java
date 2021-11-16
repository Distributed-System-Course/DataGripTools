package com.example.datagriptoolsdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//控制器只是用来接收客户端的请求。
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String homePage() {
        return "/test";
    }
}
