package com.example.datagriptoolsdesign.serves;

import com.example.datagriptoolsdesign.bean.TraceBean;
import org.springframework.stereotype.Service;

@Service
public interface DataGripServes {
    public void addTrace(TraceBean trace);
    public String showALLTrace();
    public String showTraceById(int id);
}
