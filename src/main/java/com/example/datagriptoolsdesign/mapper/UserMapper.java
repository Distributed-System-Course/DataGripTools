package com.example.datagriptoolsdesign.mapper;

import com.example.datagriptoolsdesign.bean.TraceBean;
import com.example.datagriptoolsdesign.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 映射器接口，在配置文件中绑定命名空间，通过
@Mapper
@Repository
public interface UserMapper {
    // 根据创建的实体类来定义增删改查方法
    // 查询
    public List<TraceBean> Show_all();
    public List<TraceBean> QueryById(String id, String location, String starttime, String endtime);
    public List<TraceBean> QueryByName(String Name);
    public List<TraceBean> QueryByTime(String starttime, String endtime, String location);
    public List<TraceBean> QueryByLocation(String location);
    public List<TraceBean> QueryByYear(int year);
    public List<TraceBean> QueryByMonth(int year, int Month, String location);
    public List<TraceBean> QueryByDay(int year, int Month, int Day, String location);
    public List<TraceBean> QueryByHour(int year, int Month, int Day, int Hour,String location);
    public List<TraceBean> QueryByAll(String id, String location, String Name, String starttime, String endtime);
    // 增加
    public void AddTrace(TraceBean trace);

    public UserBean getUser(String username, String password);
}
