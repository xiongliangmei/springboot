package com.runke;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.runke.entity.User;
import com.runke.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Test extends SpringBootMybatisPagehelperApplicationTests {
    @Autowired
    IUser user;


    @org.junit.Test
    public  void  test(){
        PageHelper.startPage(1,5);
        List<User> list =  user.getUserInfo();
        PageInfo<User> page = new PageInfo<>(list);
        System.out.println(page.getTotal());
    }
}
