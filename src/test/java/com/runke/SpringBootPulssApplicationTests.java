package com.runke;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.runke.entity.User;
import com.runke.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootPulssApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(13,userList.size());
        userList.forEach(System.out::println);
    }

    /***
     * mybatis-plus 分页
     */
    @Test
    public  void test(){
        Page<User> p = new Page<>(1,6);
        IPage<User> page = p.setRecords(userMapper.selectPageVo(p,new User()));
        System.out.println(page.getSize());
    }

}

