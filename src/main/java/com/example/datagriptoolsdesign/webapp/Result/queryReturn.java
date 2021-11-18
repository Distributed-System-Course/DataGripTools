package com.example.datagriptoolsdesign.webapp.Result;

import com.example.datagriptoolsdesign.webapp.POJO.tableData;

import java.util.ArrayList;
import java.util.List;

public class queryReturn {
    int status;
    List<tableData> data = new ArrayList<tableData>();
    public queryReturn(){
        this.status=200;
    }
    public void setData(tableData add){
        data.add(add);
    }
    //public void getdata(tableData add){}
    public void setStatus(int status) { this.status = status; }
    public int getStatus() { return status; }

    @Override
    public String toString() {
        return "queryReturn{" +
                "status=" + status +
                ", data=" + data.toString() +
                '}';
    }
}
