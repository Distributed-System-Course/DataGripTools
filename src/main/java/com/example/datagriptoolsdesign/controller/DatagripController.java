package com.example.datagriptoolsdesign.controller;

import com.example.datagriptoolsdesign.bean.TraceBean;
import com.example.datagriptoolsdesign.demo.Data_Processing;
import com.example.datagriptoolsdesign.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String QueryById(String id){
        ArrayList<String> trace_list = new ArrayList<>();
        List<TraceBean> traceBeans = userMapper.QueryById(id);
        traceBeans.forEach(traceBean -> {
            trace_list.add(traceBean.getLocation() + " " + traceBean.getEnter_time() + " " + traceBean.getName() + " "
             + traceBean.getId() + " " + traceBean.getPhone() + "\n");
        });
        return trace_list.toString();
    }
    @GetMapping("/QueryByTime")
    public String QueryByTime(String Starttime, String Endtime){
        ArrayList<String> trace_list = new ArrayList<>();
        List<TraceBean> traceBeans = userMapper.QueryByTime(Starttime, Endtime);
        traceBeans.forEach(traceBean -> {
            trace_list.add(traceBean.getLocation() + " " + traceBean.getEnter_time() + " " + traceBean.getName() + " "
             + traceBean.getId() + " " + traceBean.getPhone() + "\n");
        });
        return trace_list.toString();
    }
    @GetMapping("/QueryByName")
    public String QueryByName(String Name){
        ArrayList<String> trace_list = new ArrayList<>();
        List<TraceBean> traceBeans = userMapper.QueryByName(Name);
        traceBeans.forEach(traceBean -> {
            trace_list.add(traceBean.getLocation() + " " + traceBean.getEnter_time() + " " + traceBean.getName() + " "
             + traceBean.getId() + " " + traceBean.getPhone() + "\n");
        });
        return trace_list.toString();
    }
    @GetMapping("/QueryByLocation")
    public String QueryByLocation(String location){
        ArrayList<String> trace_list = new ArrayList<>();
        List<TraceBean> traceBeans = userMapper.QueryByLocation(location);
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

//    1. 获取年流量：
@GetMapping("/Year_num")
public Map<String, Integer> Year_num(int year){
/*
*   1. 接收年份，返回当年各个地点的人流量
* */
    Map<String, Integer> trace_map = new HashMap<>();
    List<TraceBean> traceBeans = userMapper.QueryByYear(year);
    trace_map.put("大悦城", 0);
    trace_map.put("汇丰银行", 0);
    trace_map.put("万达商场", 0);
    trace_map.put("工商银行", 0);
    for(TraceBean traceBean : traceBeans){
        trace_map.replace(traceBean.getLocation(), trace_map.get(traceBean.getLocation()) + 1);
    }
    return trace_map;
}

//    2. 获取某年月流量：
@GetMapping("/Month_num")
public Map<String, List<Integer>> Month_num(String datetime){
/*
*   1. 接收年份，返回该年在各个月份的人流量
* */
    int year = Integer.parseInt(datetime.substring(0, 4));
    int month = Integer.parseInt(datetime.substring(5, 7));
    int day = Integer.parseInt(datetime.substring(8, 10));
    Map<String, List<Integer>> trace_map = new HashMap<>();
    List<Integer> traceBeans_dayuecheng = new ArrayList<>();
    for(int i = 1; i <= 12; i++){
        traceBeans_dayuecheng.add(userMapper.QueryByMonth(year, i, "汇丰银行").size());
    }

    List<Integer> traceBeans_huifeng = new ArrayList<>();
    for(int i = 1; i <= 12; i++){
        traceBeans_huifeng.add(userMapper.QueryByMonth(year, i, "万达商场").size());
    }

    List<Integer> traceBeans_wanda = new ArrayList<>();
    for(int i = 1; i <= 12; i++){
        traceBeans_wanda.add(userMapper.QueryByMonth(year, i, "万达商场").size());
    }

    List<Integer> traceBeans_gongshang = new ArrayList<>();
    for(int i = 1; i <= 12; i++){
        traceBeans_gongshang.add(userMapper.QueryByMonth(year, i, "工商银行").size());
    }
    trace_map.put("大悦城", traceBeans_dayuecheng);
    trace_map.put("汇丰银行", traceBeans_huifeng);
    trace_map.put("万达商场", traceBeans_wanda);
    trace_map.put("工商银行", traceBeans_gongshang);

    return trace_map;
}

//    1. 获取某月日流量
@GetMapping("/Day_num")
public Map<String, List<Integer>> Day_num(String datetime ){
/*
*   1. 接收年月，返回当月各个地点每日的人流量
* */
    int year = Integer.parseInt(datetime.substring(0, 4));
    int month = Integer.parseInt(datetime.substring(5, 7));
    int day = Integer.parseInt(datetime.substring(8, 10));
    Map<String, List<Integer>> trace_map = new HashMap<>();
//    List<TraceBean> traceBeans = userMapper.QueryByDay(year, month, day, location);
    List<Integer> traceBeans_dayuecheng = new ArrayList<>();
    List<Integer> traceBeans_huifeng = new ArrayList<>();
    List<Integer> traceBeans_wanda = new ArrayList<>();
    List<Integer> traceBeans_gongshang = new ArrayList<>();
    for(int i = 1; i <= 31; i++){
        traceBeans_dayuecheng.add(userMapper.QueryByDay(year, month, i,  "汇丰银行").size());
    }
    for(int i = 1; i <= 31; i++){
        traceBeans_huifeng.add(userMapper.QueryByDay(year, month, i,  "汇丰银行").size());
    }
    for(int i = 1; i <= 31; i++){
        traceBeans_wanda.add(userMapper.QueryByDay(year, month, i,  "汇丰银行").size());
    }
    for(int i = 1; i <= 31; i++){
        traceBeans_gongshang.add(userMapper.QueryByDay(year, month, i,  "汇丰银行").size());
    }

    trace_map.put("大悦城", traceBeans_dayuecheng);
    trace_map.put("汇丰银行", traceBeans_huifeng);
    trace_map.put("万达商场", traceBeans_wanda);
    trace_map.put("工商银行", traceBeans_gongshang);

    return trace_map;
}
// 返回某日的时流量
@GetMapping("/Hour_num")
public Map<String, List<Integer>> Hour_num(String datetime) {
    /*
     *   1. 接收年月日，返回当日各个地点每个时刻的人流量
     * */
    int year = Integer.parseInt(datetime.substring(0, 4));
    int month = Integer.parseInt(datetime.substring(5, 7));
    int day = Integer.parseInt(datetime.substring(8, 10));
    Map<String, List<Integer>> trace_map = new HashMap<>();
    List<Integer> traceBeans_dayuecheng = new ArrayList<>();
    List<Integer> traceBeans_huifeng = new ArrayList<>();
    List<Integer> traceBeans_wanda = new ArrayList<>();
    List<Integer> traceBeans_gongshang = new ArrayList<>();
    for (int i = 1; i <= 24; i++) {
        traceBeans_dayuecheng.add(userMapper.QueryByHour(year, month, day, i, "汇丰银行").size());
    }
    for (int i = 1; i <= 24; i++) {
        traceBeans_huifeng.add(userMapper.QueryByHour(year, month, day, i, "汇丰银行").size());
    }
    for (int i = 1; i <= 24; i++) {
        traceBeans_wanda.add(userMapper.QueryByHour(year, month, day, i, "汇丰银行").size());
    }
    for (int i = 1; i <= 24; i++) {
        traceBeans_gongshang.add(userMapper.QueryByHour(year, month, day, i, "汇丰银行").size());
    }
    trace_map.put("大悦城", traceBeans_dayuecheng);
    trace_map.put("汇丰银行", traceBeans_huifeng);
    trace_map.put("万达商场", traceBeans_wanda);
    trace_map.put("工商银行", traceBeans_gongshang);

    return trace_map;
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
