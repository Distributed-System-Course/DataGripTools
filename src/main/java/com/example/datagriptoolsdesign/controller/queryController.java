package com.example.datagriptoolsdesign.controller;

import com.example.datagriptoolsdesign.webapp.POJO.queryForm;
import com.example.datagriptoolsdesign.webapp.Result.queryReturn;
import com.example.datagriptoolsdesign.webapp.POJO.tableData;
import org.springframework.web.bind.annotation.*;

//控制器只是用来接收客户端的请求。
@RestController
public class queryController {
    @CrossOrigin
    @PostMapping(value = "api/query")
    @ResponseBody
    public queryReturn query(@RequestBody queryForm query) {
        // 对 html 标签进行转义，防止 XSS 攻击
        tableData test=new tableData("01110","2016-05-02","张三","中关村");
        queryReturn result=new queryReturn();
        result.addData(test);
        return result;
    }
}
