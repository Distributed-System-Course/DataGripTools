package com.example.datagriptoolsdesign.controller;

import com.example.datagriptoolsdesign.bean.TraceBean;
import com.example.datagriptoolsdesign.demo.Data_Processing;
import com.example.datagriptoolsdesign.mapper.UserMapper;
import com.example.datagriptoolsdesign.webapp.Result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;

//控制器只是用来接收客户端的请求。
@Controller
public class Reciever {
    @RequestMapping(value = "/up")
    public String homePage() {
        return "/up";
    }
    @Autowired
    private UserMapper userMapper;

    @CrossOrigin
    @RequestMapping("api/upload")
    @ResponseBody
    public Object handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(
                                "src/main/resources/进入登记.xlsx")));
                System.out.println(file.getName());
                out.write(file.getBytes());
                out.flush();
                out.close();
                ArrayList<TraceBean> traceBeans = new ArrayList<>();
                Data_Processing data_processing = new Data_Processing();
                try {
                    data_processing.init("src/main/resources/进入登记.xlsx");
                    data_processing.processing();
                    data_processing.getLogs().forEach(System.out::println);
                    traceBeans = data_processing.upload();
                    traceBeans.forEach(System.out::println);
                    traceBeans.forEach(traceBean -> {
                        userMapper.AddTrace(traceBean);
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }

            return new Result(200);

        } else {
            System.out.println("test");
            return new Result(400);
        }
    }


}
