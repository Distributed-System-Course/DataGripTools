package com.example.datagriptoolsdesign.webapp.POJO;

import java.util.ArrayList;
import java.util.List;

public class line {
    List<Integer> huifengdata ;
    List<Integer> dayuedata ;
    List<Integer> wandadata ;
    List<Integer> gongshangdata ;

    public void setDayuedata(List<Integer> dayuedata) {
        this.dayuedata = dayuedata;
    }
    public void setGongshangdata(List<Integer> gongshangdata) {
        this.gongshangdata = gongshangdata;
    }
    public void setHuifengdata(List<Integer> huifengdata) {
        this.huifengdata = huifengdata;
    }
    public void setWandadata(List<Integer> wandadata) {
        this.wandadata = wandadata;
    }

    public List<Integer> getDayuedata() {
        return dayuedata;
    }

    public List<Integer> getGongshangdata() {
        return gongshangdata;
    }

    public List<Integer> getHuifengdata() {
        return huifengdata;
    }

    public List<Integer> getWandadata() {
        return wandadata;
    }
}
