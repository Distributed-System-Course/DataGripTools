package com.example.datagriptoolsdesign.serves;

import com.example.datagriptoolsdesign.bean.TraceBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface DataGripServes {
    public void addTrace(ArrayList<TraceBean> traceBeans);
    public String showALLTrace();
    public String showTraceById(int id);
}
