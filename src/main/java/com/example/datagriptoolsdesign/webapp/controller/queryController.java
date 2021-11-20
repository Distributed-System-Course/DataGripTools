package com.example.datagriptoolsdesign.webapp.controller;


import com.example.datagriptoolsdesign.bean.TraceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import com.example.datagriptoolsdesign.mapper.UserMapper;
import java.util.Map;
import java.util.Objects;
import com.example.datagriptoolsdesign.webapp.POJO.queryForm;
import com.example.datagriptoolsdesign.webapp.Result.queryReturn;
import com.example.datagriptoolsdesign.webapp.POJO.tableData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//控制器只是用来接收客户端的请求。
@RestController
public class queryController {
    @Autowired
    private UserMapper userMapper;
    @CrossOrigin
    @PostMapping(value = "api/query",produces = "application/json")//;charset=UTF-8
    @ResponseBody
    public List<tableData> query(@RequestBody Map map) {
        // 对 html 标签进行转义，防止 XSS 攻击
        int id=(int)map.get("inputid");
        String name=(String)map.get("inputname");
        String add=(String)map.get("inputaddress");
        String starttime=(String)(((List)map.get("inputdate")).get(0));
        String endtime=(String)(((List)map.get("inputdate")).get(1));
        ArrayList<tableData> id_trace_list = new ArrayList<>();
        List<TraceBean> traceBeans = userMapper.QueryById(id);
        traceBeans.forEach(traceBean -> {
                    id_trace_list.add(new tableData(traceBean.getId(), traceBean.getEnter_time(), traceBean.getName(), traceBean.getLocation()));
                });
        ArrayList<tableData> name_trace_list = new ArrayList<>();
        List<TraceBean> n_traceBeans = userMapper.QueryByName(name);
        n_traceBeans.forEach(n_traceBean -> {
            name_trace_list.add(new tableData(n_traceBean.getId(), n_traceBean.getEnter_time(), n_traceBean.getName(), n_traceBean.getLocation()));
        });
        id_trace_list.retainAll(name_trace_list);
        System.out.println(id_trace_list);
        tableData test=new tableData("01110","2016-05-02","张三","中关村");
        queryReturn result=new queryReturn();
        result.setData(test);
        List<tableData> data = new ArrayList<tableData>();
        data.add(test);
        return data;
    }
}
