package com.example.datagriptoolsdesign.controller;

import com.example.datagriptoolsdesign.bean.TraceBean;
import com.example.datagriptoolsdesign.bean.UserBean;
import com.example.datagriptoolsdesign.demo.Data_Processing;
import com.example.datagriptoolsdesign.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
//控制器只是用来接收客户端的请求。
@RestController
public class DatagripController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/Show_all")
    public String Show_all(){

        ArrayList<String> trace_list = new ArrayList<>();
        List<TraceBean> traceBeans = userMapper.Show_all();
        traceBeans.forEach(traceBean -> {
            trace_list.add(traceBean.getLocation() + " " + traceBean.getEnter_time() + " " + traceBean.getName() + " "
             + traceBean.getId() + " " + traceBean.getPhone() + "\n");
        });
        return trace_list.toString();
    }

    @GetMapping("/QueryById")
    public String QueryById(int id){
        ArrayList<String> trace_list = new ArrayList<>();
        List<TraceBean> traceBeans = userMapper.QueryById(id);
        traceBeans.forEach(traceBean -> {
            trace_list.add(traceBean.getLocation() + " " + traceBean.getEnter_time() + " " + traceBean.getName() + " "
             + traceBean.getId() + " " + traceBean.getPhone() + "\n");
        });
        return trace_list.toString();
    }
    @GetMapping("/AddTrace")
    public String AddTrace(){
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
        return "OK";
    }

//@GetMapping("/Verify")
//    public Boolean VerifyUser(String username, String password){
//    UserBean userBean = userMapper.getUser(username, password);
//    if (userBean.getUsername() .equals("")){
//        return Boolean.FALSE;
//    }
//    else{
//        return Boolean.TRUE;
//    }
//}


}
