package com.example.datagriptoolsdesign.controller;

import com.example.datagriptoolsdesign.bean.TraceBean;
import com.example.datagriptoolsdesign.demo.Data_Processing;
import com.example.datagriptoolsdesign.mapper.UserMapper;
import com.example.datagriptoolsdesign.webapp.POJO.Pie;
import com.example.datagriptoolsdesign.webapp.POJO.line;
import com.example.datagriptoolsdesign.webapp.POJO.tableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/QueryById")
//    public String QueryById(String id, String location){
//        ArrayList<String> trace_list = new ArrayList<>();
//        List<TraceBean> traceBeans = userMapper.QueryById(id, location, starttime, endtime);
//        traceBeans.forEach(traceBean -> {
//            trace_list.add(traceBean.getLocation() + " " + traceBean.getEnter_time() + " " + traceBean.getName() + " "
//             + traceBean.getId() + " " + traceBean.getPhone() + "\n");
//        });
//        return trace_list.toString();
//    }
    @GetMapping("/QueryByTime")
    public String QueryByTime(String Starttime, String Endtime, String location){
        ArrayList<String> trace_list = new ArrayList<>();
        List<TraceBean> traceBeans = userMapper.QueryByTime(Starttime, Endtime, location);
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
@CrossOrigin
@PostMapping(value = "api/piediagyear",produces = "application/json")//;charset=UTF-8
@ResponseBody
public List<Pie> Year_num(@RequestBody String year){
/*
*   1. 接收年份，返回当年各个地点的人流量
* */
    year=year.split("-")[0].substring(1);
    Map<String, Integer> trace_map = new HashMap<>();
    int iyear=Integer.valueOf(year).intValue()+1;
    System.out.println(iyear);
    List<TraceBean> traceBeans = userMapper.QueryByYear(iyear);
    trace_map.put("大悦城", 0);
    trace_map.put("汇丰银行", 0);
    trace_map.put("万达商场", 0);
    trace_map.put("中国工商银行", 0);
    for(TraceBean traceBean : traceBeans){
        trace_map.replace(traceBean.getLocation(), trace_map.get(traceBean.getLocation()) + 1);
    }
    int a=(int)trace_map.get("大悦城");
    int b=(int)trace_map.get("汇丰银行");
    int c=(int)trace_map.get("万达商场");
    int d=(int)trace_map.get("中国工商银行");
    System.out.println(a);
    List<Pie> data = new ArrayList<>();
    data.add(new Pie(a,"大悦城"));
    data.add(new Pie(b,"汇丰银行"));
    data.add(new Pie(c,"万达商场"));
    data.add(new Pie(d,"中国工商银行"));
    System.out.println(data);
    return data;
}

//    1. 获取月流量（pie）：
@CrossOrigin
@PostMapping(value = "api/piediagmonth",produces = "application/json")//;charset=UTF-8
@ResponseBody
public List<Pie> Year_Month_num(@RequestBody String date){
    /*
     *   1. 接收年份，返回当年各个地点的人流量
     * */
    int year =Integer.parseInt(date.split("-")[0].substring(1));
    int month = Integer.parseInt(date.split("-")[1])+1;
    System.out.println(year);
    System.out.println(month);
    Map<String, Integer> trace_map = new HashMap<>();
    int dayuecheng = userMapper.QueryByMonth(year, month, "大悦城").size();
    int huifeng = userMapper.QueryByMonth(year, month, "汇丰银行").size();
    int wanda = userMapper.QueryByMonth(year, month, "万达商场").size();
    int gongshang = userMapper.QueryByMonth(year, month, "中国工商银行").size();
    System.out.println(dayuecheng);
    System.out.println(huifeng);
    System.out.println(wanda);
    System.out.println(gongshang);

    List<Pie> mdata = new ArrayList<>();
    mdata.add(new Pie(dayuecheng,"大悦城"));
    mdata.add(new Pie(huifeng,"汇丰银行"));
    mdata.add(new Pie(wanda,"万达商场"));
    mdata.add(new Pie(gongshang,"中国工商银行"));
    System.out.println(mdata);
    return mdata;
}
//    1. 获取年流量：
@CrossOrigin
@PostMapping(value = "api/piediagday",produces = "application/json")//;charset=UTF-8
@ResponseBody

public List<Pie> Year_Month_Day_num(@RequestBody String date){
    /*
     *   1. 接收年份，返回当年各个地点的人流量
     * */
    int year =Integer.parseInt(date.split("-")[0].substring(1));
    int month = Integer.parseInt(date.split("-")[1]);
    int day = Integer.parseInt(date.split("-")[2].split(" ")[0].split("T")[0])+1;
    System.out.println(year);
    System.out.println(month);
    System.out.println(day);
    Map<String, Integer> trace_map = new HashMap<>();
    int dayuecheng = userMapper.QueryByDay(year, month, day, "大悦城").size();
    int huifeng = userMapper.QueryByDay(year, month, day, "汇丰银行").size();
    int wanda = userMapper.QueryByDay(year, month, day, "万达商场").size();
    int gongshang = userMapper.QueryByDay(year, month, day, "中国工商银行").size();
    List<Pie> ddata = new ArrayList<>();
    ddata.add(new Pie(dayuecheng,"大悦城"));
    ddata.add(new Pie(huifeng,"汇丰银行"));
    ddata.add(new Pie(wanda,"万达商场"));
    ddata.add(new Pie(gongshang,"中国工商银行"));
    System.out.println(ddata);
    return ddata;
}



//    2. 获取某年月流量：
@CrossOrigin
@PostMapping(value = "api/linediagyear",produces = "application/json")//;charset=UTF-8
@ResponseBody
public line Month_num(@RequestBody String date){
/*
*   1. 接收年份，返回该年在各个月份的人流量
* */
    int year =Integer.parseInt(date.split("-")[0].substring(1))+1;
    System.out.println(year);
    int month = Integer.parseInt(date.split("-")[1]);
    int day = Integer.parseInt(date.split("-")[2].split(" ")[0].split("T")[0])+1;
    Map<String, List<Integer>> trace_map = new HashMap<>();
    List<Integer> traceBeans_dayuecheng = new ArrayList<>();
    for(int i = 1; i <= 12; i++){
        System.out.println(year);
        System.out.println(i);
        traceBeans_dayuecheng.add(userMapper.QueryByMonth(year, i, "大悦城").size());
        System.out.println(userMapper.QueryByMonth(year, i, "大悦城"));
    }

    List<Integer> traceBeans_huifeng = new ArrayList<>();
    for(int i = 1; i <= 12; i++){
        traceBeans_huifeng.add(userMapper.QueryByMonth(year, i, "汇丰银行").size());
    }

    List<Integer> traceBeans_wanda = new ArrayList<>();
    for(int i = 1; i <= 12; i++){
        traceBeans_wanda.add(userMapper.QueryByMonth(year, i, "万达商场").size());
    }

    List<Integer> traceBeans_gongshang = new ArrayList<>();
    for(int i = 1; i <= 12; i++){
        traceBeans_gongshang.add(userMapper.QueryByMonth(year, i, "中国工商银行").size());
    }
    line yline=new line();
    yline.setDayuedata(traceBeans_dayuecheng);
    yline.setGongshangdata(traceBeans_gongshang);
    yline.setHuifengdata(traceBeans_huifeng);
    yline.setWandadata(traceBeans_wanda);
    return yline;
}

//    1. 获取某月日流量
@CrossOrigin
@PostMapping(value = "api/linediagmonth",produces = "application/json")//;charset=UTF-8
@ResponseBody
public line Day_num(@RequestBody String date){
/*
*   1. 接收年月，返回当月各个地点每日的人流量
* */
    int year =Integer.parseInt(date.split("-")[0].substring(1));
    int month = Integer.parseInt(date.split("-")[1])+1;
    int day = Integer.parseInt(date.split("-")[2].split(" ")[0].split("T")[0]);
    System.out.println(year);
    System.out.println(month);
    System.out.println(day);
    //int day = Integer.parseInt(datetime.substring(8, 10));
    Map<String, List<Integer>> trace_map = new HashMap<>();
//    List<TraceBean> traceBeans = userMapper.QueryByDay(year, month, day, location);
    List<Integer> traceBeans_dayuecheng = new ArrayList<>();
    List<Integer> traceBeans_huifeng = new ArrayList<>();
    List<Integer> traceBeans_wanda = new ArrayList<>();
    List<Integer> traceBeans_gongshang = new ArrayList<>();
    for(int i = 1; i <= 31; i++){
        traceBeans_dayuecheng.add(userMapper.QueryByDay(year, month, i,  "大悦城").size());
    }
    for(int i = 1; i <= 31; i++){
        traceBeans_huifeng.add(userMapper.QueryByDay(year, month, i,  "汇丰银行").size());
    }
    for(int i = 1; i <= 31; i++){
        traceBeans_wanda.add(userMapper.QueryByDay(year, month, i,  "万达商场").size());
    }
    for(int i = 1; i <= 31; i++){
        traceBeans_gongshang.add(userMapper.QueryByDay(year, month, i,  "中国工商银行").size());
    }
    System.out.println(traceBeans_dayuecheng);
    System.out.println(traceBeans_huifeng);
    System.out.println(traceBeans_wanda);
    System.out.println(traceBeans_gongshang);
    line mline=new line();
    mline.setDayuedata(traceBeans_dayuecheng);
    mline.setGongshangdata(traceBeans_gongshang);
    mline.setHuifengdata(traceBeans_huifeng);
    mline.setWandadata(traceBeans_wanda);
    System.out.println(mline.getHuifengdata());
    System.out.println(mline.getGongshangdata());
    System.out.println(mline.getDayuedata());
    System.out.println(mline.getWandadata());

    return mline;
}
// 返回某日的时流量
@CrossOrigin
@PostMapping(value = "api/linediagday",produces = "application/json")//;charset=UTF-8
@ResponseBody
public line Hour_num(@RequestBody String date) {
    /*
     *   1. 接收年月日，返回当日各个地点每个时刻的人流量
     * */
    int year =Integer.parseInt(date.split("-")[0].substring(1));
    int month = Integer.parseInt(date.split("-")[1]);
    int day = Integer.parseInt(date.split("-")[2].split(" ")[0].split("T")[0])+1;
    System.out.println(year);
    System.out.println(month);
    System.out.println(day);
    Map<String, List<Integer>> trace_map = new HashMap<>();
    List<Integer> traceBeans_dayuecheng = new ArrayList<>();
    List<Integer> traceBeans_huifeng = new ArrayList<>();
    List<Integer> traceBeans_wanda = new ArrayList<>();
    List<Integer> traceBeans_gongshang = new ArrayList<>();
    for (int i = 1; i <= 24; i++) {
        traceBeans_dayuecheng.add(userMapper.QueryByHour(year, month, day, i, "大悦城").size());
    }
    for (int i = 1; i <= 24; i++) {
        traceBeans_huifeng.add(userMapper.QueryByHour(year, month, day, i, "汇丰银行").size());
    }
    for (int i = 1; i <= 24; i++) {
        traceBeans_wanda.add(userMapper.QueryByHour(year, month, day, i, "万达商场").size());
    }
    for (int i = 1; i <= 24; i++) {
        traceBeans_gongshang.add(userMapper.QueryByHour(year, month, day, i, "中国工商银行").size());
    }

    line dline=new line();
    dline.setDayuedata(traceBeans_dayuecheng);
    dline.setGongshangdata(traceBeans_gongshang);
    dline.setHuifengdata(traceBeans_huifeng);
    dline.setWandadata(traceBeans_wanda);
    return dline;
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
