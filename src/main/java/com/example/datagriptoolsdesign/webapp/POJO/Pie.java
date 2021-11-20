package com.example.datagriptoolsdesign.webapp.POJO;

public class Pie {
    int value;
    String name;
    public Pie(int value, String name){this.name=name;this.value=value;}
    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Pie{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
