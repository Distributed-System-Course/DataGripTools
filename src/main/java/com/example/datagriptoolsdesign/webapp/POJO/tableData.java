package com.example.datagriptoolsdesign.webapp.POJO;

import com.example.datagriptoolsdesign.webapp.Result.Result;

import static java.lang.Integer.valueOf;

public class tableData {
    String date;
    String name;
    String address;
    int id;
    Result r;
    public tableData(String inId, String inDate, String inName, String inAddress){
        this.id= valueOf(inId).intValue();
        this.date=inDate;
        this.name=inName;
        this.address=inAddress;

    }
    public void setId(String inId) {
        this.id= valueOf(inId).intValue();
    }
    public void setDate(String inDate){this.date=inDate;}
    public void setName(String inName){this.name=inName;}
    public void setAddress(String inAddress){this.address=inAddress;}
}
