package com.example.datagriptoolsdesign.mapper;

import com.example.datagriptoolsdesign.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    UserBean getInfo(String name, String password);
}
