package com.example.datagriptoolsdesign.webapp.POJO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class queryForm {
    String inputId;
    //String inputAddress;
    //String inputName;
    //List<Date> inputdate = new ArrayList<Date>()

    public String getId() {
        return inputId;
    }
    public void setId(String inputId) {
        this.inputId=inputId;
    }
    //public Date getStartDate(){return inputdate.get(0);}
    //public Date getEndDate(){return inputdate.get(1);}
    //public String getName(){return inputName;}
    //public String getAddress(){return inputAddress;}

    //public Date getStartDate(){return inputdate.get(0);}
    //public Date getEndDate(){return inputdate.get(1);}
    //public void setName(String inputname){this.inputName=inputname;}
    //public void setAddress(String inputaddress){this.inputAddress=inputaddress;}

    @Override
    public String toString() {
        return "queryForm{" +
                "inputid='" + inputId + '\'' +
                //", inputaddress='" + inputAddress + '\'' +
                //", inputname='" + inputName + '\'' +
                '}';
    }
}
