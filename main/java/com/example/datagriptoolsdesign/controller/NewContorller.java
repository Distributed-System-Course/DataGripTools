package com.example.datagriptoolsdesign.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewContorller {
    @RequestMapping("/index")
    public String sayHello(){
        return  "index";
    }
}
