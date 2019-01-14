package com.runke.service.impl;

import com.runke.entity.User;
import com.runke.mapper.UserMapper;
import com.runke.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserImpl implements IUser {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> getUserInfo() {
        return userMapper.getUserInfo();
    }
}
