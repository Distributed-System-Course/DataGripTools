package com.example.datagriptoolsdesign.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class TraceBean {
    private String location;
    private String enter_time;
    private String Name;
    private String phone;
    private String id;

    public TraceBean(String location, String enter_time, String Name, String phone, String id){
        this.location = location;
        this.enter_time = enter_time;
        this.Name = Name;
        this.phone = phone;
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public String getEnter_time() {
        return enter_time;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setEnter_time(String enter_time) {
        this.enter_time = enter_time;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(String id) {
        this.id = id;
    }

}
