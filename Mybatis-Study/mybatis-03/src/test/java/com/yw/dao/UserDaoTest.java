package com.yw.dao;

import com.yw.pojo.User;
import com.yw.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test(){
//        UserMapper userDao=new UserMapperImpl();
//        List<User> users=userDao.getUserList();
//        for (User user : users) {
//            System.out.println(user);
//        }
    }

    @Test
    public void test2(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        try{
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.getUserById(1));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

//    @Test
//    public void getUserLike(){
//        SqlSession sqlSession= MyBatisUtil.getSqlSession();
//
//        try{
//            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
//            System.out.println(userMapper.getUserLike("小"));
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            sqlSession.close();
//        }
//
//    }

    @Test
    public void test3(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        try{
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.addUser(new User(5,"小学","233444")));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //提交事务
            sqlSession.commit();
            sqlSession.close();
        }

    }

//    @Test
//    public void test3_1(){
//        SqlSession sqlSession= MyBatisUtil.getSqlSession();
//
//        try{
//            Map<String,Object> map=new HashMap<String,Object>();
//            map.put("userid",5);
//            map.put("username","小学");
//            map.put("userpwd","233444");
//
//            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
//            System.out.println(userMapper.addUser2(map));
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            //提交事务
//            sqlSession.commit();
//            sqlSession.close();
//        }
//
//    }

    @Test
    public void test4(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        try{
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.updateUSer(new User(5,"小学33","233444")));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //提交事务
            sqlSession.commit();
            sqlSession.close();
        }

    }



    @Test
    public void test5(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        try{
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.deleteUser(5));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //提交事务
            sqlSession.commit();
            sqlSession.close();
        }

    }
}
