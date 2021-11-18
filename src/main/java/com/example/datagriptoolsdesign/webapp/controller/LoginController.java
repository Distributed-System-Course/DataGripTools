package com.example.datagriptoolsdesign.webapp.controller;

import com.example.datagriptoolsdesign.webapp.POJO.User;
import com.example.datagriptoolsdesign.webapp.Result.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@RestController
public class LoginController {

    @CrossOrigin
    @PostMapping(value = "api/login",produces = "application/json")
    @ResponseBody
    public Result login(@RequestBody User requestUser) {
        // 对 html 标签进行转义，防止 XSS 攻击
        System.out.println(requestUser.toString());
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);

        if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassword())) {
            String message = "账号密码错误";
            System.out.println("test");
            return new Result(400);
        } else {
            return new Result(200);
        }
    }
}
