package com.yw.dao;

import com.yw.pojo.User;
import com.yw.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void  test(){
        SqlSession session= MyBatisUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        List<User> users=userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        session.close();

    }

    @Test
    public void  getUserById(){
        SqlSession session= MyBatisUtil.getSqlSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.getUserById(1);
        System.out.println(user);
        session.close();

    }
}
