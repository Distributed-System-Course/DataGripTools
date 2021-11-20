package com.example.datagriptoolsdesign.webapp.POJO;

import com.example.datagriptoolsdesign.webapp.Result.Result;

import static java.lang.Integer.valueOf;

public class tableData {
    String date;
    String name;
    String address;
    String id;
    public tableData(String inId, String inDate, String inName, String inAddress){
        this.id= inId;
        this.date=inDate;
        this.name=inName;
        this.address=inAddress;

    }
    public void setId(String inId) {
        this.id= inId;
    }
    public void setDate(String inDate){this.date=inDate;}
    public void setName(String inName){this.name=inName;}
    public void setAddress(String inAddress){this.address=inAddress;}
    public String getId() {
        return this.id;
    }
    public String getDate(){return this.date;}
    public String getName(){return this.name;}
    public String getAddress(){return this.address;}

    @Override
    public String toString() {
        return "tableData{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                '}';
    }
}
