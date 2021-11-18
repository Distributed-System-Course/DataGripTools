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
    public void addData(tableData add){
        data.add(add);
    }
}
