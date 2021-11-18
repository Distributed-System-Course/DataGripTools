package com.example.datagriptoolsdesign.webapp.POJO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class queryForm {
    String name;
    String address;
    String inputid;
    List<Date> date = new ArrayList<Date>();
    public int getId() {
        return Integer.valueOf(inputid).intValue();
    }
    public Date getStartDate(){return date.get(0);}
    public Date getEndDate(){return date.get(1);}
    public String getName(){return name;}
    public String getAddress(){return address;}
}
