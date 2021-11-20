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
    @PostMapping(value = "api/query", produces = "application/json")//;charset=UTF-8
    @ResponseBody
    public List<tableData> query(@RequestBody Map map) {
        ArrayList<tableData> traceBeans = new ArrayList<>();
        // 对 html 标签进行转义，防止 XSS 攻击
        System.out.println(map);
        String id = (String) map.get("inputid");
        String name = (String) map.get("inputname");
        String add = (String) map.get("inputaddress");
        String starttime = ((String) (((List) map.get("inputdate")).get(0))).split("T")[0];
        String endtime = ((String) (((List) map.get("inputdate")).get(1))).split("T")[0];
        System.out.println(name);
        System.out.println(id);
        System.out.println(add);
        System.out.println(starttime);
        System.out.println(endtime);
//        List<TraceBean> traceBeans = userMapper.QueryByAll(id, add, name, starttime, endtime);
//        traceBeans.forEach(traceBean -> {
//                trace_list.add(new tableData(traceBean.getId(), traceBean.getEnter_time(), traceBean.getName(), traceBean.getLocation()));
//        });
//      anshijian jinxingsousuo
        System.out.println((id.equals("")));
        System.out.println((name.equals("")));
        System.out.println((add.equals("")));

        if(starttime != null && id.equals("")){
            System.out.println("1");
            List<TraceBean> traceBeans_time = userMapper.QueryByTime(starttime, endtime, add);
            ArrayList<tableData> time_trace_list = new ArrayList<>();
            System.out.println(traceBeans_time);
            traceBeans_time.forEach(traceBean -> {
                time_trace_list.add(new tableData(traceBean.getId(), traceBean.getEnter_time(), traceBean.getName(), traceBean.getLocation()));
            });
            System.out.println(time_trace_list);
            return time_trace_list;
        }else if (!id.equals("")){
            System.out.println("2");
            List<TraceBean> traceBeans_id = userMapper.QueryById(id,  add, starttime, endtime);
            ArrayList<tableData> id_trace_list = new ArrayList<>();
            System.out.println(traceBeans_id);
            traceBeans_id.forEach(traceBean -> {
                id_trace_list.add(new tableData(traceBean.getId(), traceBean.getEnter_time(), traceBean.getName(), traceBean.getLocation()));
            });
            System.out.println(id_trace_list);
            return id_trace_list;
        }


            return traceBeans;
        }

//        if(id.equals("") && name.equals("") && starttime != null && endtime != null) {
//            System.out.println("1");
//            List<TraceBean> traceBeans_time = userMapper.QueryByTime(starttime, endtime, add);
//            ArrayList<tableData> time_trace_list = new ArrayList<>();
//            System.out.println(traceBeans_time);
//            traceBeans_time.forEach(traceBean -> {
//                time_trace_list.add(new tableData(traceBean.getId(), traceBean.getEnter_time(), traceBean.getName(), traceBean.getLocation()));
//            });
//            System.out.println(time_trace_list);
//            return time_trace_list;
//        }
//        else if((id != null && name != null) || (!id.equals("") && !name.equals(""))){
//            System.out.println(id);
//            System.out.println(name);
//            System.out.println("2");
//            ArrayList<tableData> id_trace_list = new ArrayList<>();
//            List<TraceBean> traceBeans = userMapper.QueryById(id, add, starttime, endtime);
//            traceBeans.forEach(traceBean -> {
//                id_trace_list.add(new tableData(traceBean.getId(), traceBean.getEnter_time(), traceBean.getName(), traceBean.getLocation()));
//            });
//            //System.out.println(id_trace_list);
//            ArrayList<tableData> name_trace_list = new ArrayList<>();
//            List<TraceBean> na_traceBeans = userMapper.QueryByName(name);
//            traceBeans.forEach(na_traceBean -> {
//                name_trace_list.add(new tableData(na_traceBean.getId(), na_traceBean.getEnter_time(), na_traceBean.getName(), na_traceBean.getLocation()));
//            });
//            return id_trace_list;
//        }
//        else if(id != null){
//            System.out.println("3");
//            List<TraceBean> traceBeans_id = userMapper.QueryById(id, add, starttime, endtime);
//            ArrayList<tableData> id_trace_list = new ArrayList<>();
//            traceBeans_id.forEach(traceBean -> {
//                id_trace_list.add(new tableData(traceBean.getId(), traceBean.getEnter_time(), traceBean.getName(), traceBean.getLocation()));
//            });
//            return id_trace_list;
//        }
//        else if(add != null){
//            System.out.println("4");
//            System.out.println(starttime);
//            List<TraceBean> traceBeans_add = userMapper.QueryByLocation(add);
//            ArrayList<tableData> add_trace_list = new ArrayList<>();
//            traceBeans_add.forEach(traceBean -> {
//                add_trace_list.add(new tableData(traceBean.getId(), traceBean.getEnter_time(), traceBean.getName(), traceBean.getLocation()));
//            });
//            return add_trace_list;
//        }
//        else{
//            System.out.println("5");
//            System.out.println("else");
//        }
//
//        return trace_list;
//
//    }

}
