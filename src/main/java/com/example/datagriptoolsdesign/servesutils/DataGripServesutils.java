package com.example.datagriptoolsdesign.servesutils;

import com.example.datagriptoolsdesign.bean.TraceBean;
import com.example.datagriptoolsdesign.demo.Data_Processing;
import com.example.datagriptoolsdesign.mapper.UserMapper;
import com.example.datagriptoolsdesign.serves.DataGripServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataGripServesutils implements DataGripServes {

    @Autowired
    UserMapper userMapper;

    @Override
    public void addTrace(ArrayList<TraceBean> traceBeans) {
        try {
            traceBeans.forEach(traceBean -> {
                userMapper.AddTrace(traceBean);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String showALLTrace() {
        ArrayList<String> trace_list = new ArrayList<>();
        List<TraceBean> traceBeans = userMapper.Show_all();
        traceBeans.forEach(traceBean -> {
            trace_list.add(traceBean.getLocation() + " " + traceBean.getEnter_time() + " " + traceBean.getName() + " "
                    + traceBean.getId() + " " + traceBean.getPhone() + "\n");
        });
        return trace_list.toString();
    }

    @Override
    public String showTraceById(String id) {
        ArrayList<String> trace_list = new ArrayList<>();
        List<TraceBean> traceBeans = userMapper.QueryById(id);
        traceBeans.forEach(traceBean -> {
            trace_list.add(traceBean.getLocation() + " " + traceBean.getEnter_time() + " " + traceBean.getName() + " "
                    + traceBean.getId() + " " + traceBean.getPhone() + "\n");
        });
        return trace_list.toString();
    }
}
