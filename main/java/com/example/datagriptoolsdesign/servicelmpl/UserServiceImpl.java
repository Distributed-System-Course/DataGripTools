package com.example.datagriptoolsdesign.servicelmpl;

import com.example.datagriptoolsdesign.bean.UserBean;
import com.example.datagriptoolsdesign.mapper.UserMapper;
import com.example.datagriptoolsdesign.service.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    //将DAO注入Sever层
    @Resource
    private UserMapper userMapper;
    @Override
    public UserBean logIn(String name, String password) {
        return userMapper.getInfo(name,password);
    }
}
