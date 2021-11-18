package com.example.datagriptoolsdesign.controller;

import com.example.datagriptoolsdesign.webapp.Result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class Reciever {

    @RequestMapping(value = "/up")
    public String homePage() {
        return "/up";
    }
    @CrossOrigin
    @RequestMapping("/upload")
    @ResponseBody
    public Result handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File(
                                "src/main/resources/test.xlsx")));
                System.out.println(file.getName());
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println( "上传失败," + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println( "上传失败," + e.getMessage());
            }

            return new Result(200);

        } else {
            return new Result(400);
        }
    }


}
