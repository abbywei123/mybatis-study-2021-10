package com.yw.dao;

import com.yw.pojo.User;

import java.util.List;

public interface UserMapper {

    public List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUSer(User user);

    int deleteUser(int id);


}
