package com.yw.dao;

import com.yw.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    public List<User> getUsers();

    @Select("select * from user where id=#{id}")
    User getUserById(@Param("id")int id);
}
