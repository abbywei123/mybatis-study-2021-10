package com.yw.dao;

import com.yw.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserLike(String value);

    public List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int addUser2(Map<String,Object> map);

    int updateUSer(User user);

    int deleteUser(int id);


}
