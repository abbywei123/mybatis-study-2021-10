package com.yw.dao;

import com.yw.pojo.User;
import com.yw.utils.MyBatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    static Logger logger=Logger.getLogger(UserDaoTest.class);
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

    @Test
    public void getUserByLimit(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        try{
            HashMap<String,Integer> map=new HashMap<>();
            map.put("startIndex",1);
            map.put("pageSize",2);
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
            List<User> users=userMapper.getUserByLimit(map);
            for (User user : users) {
                System.out.println(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();

        try{
            //rowBounds 实现
            RowBounds rowBounds= new RowBounds(1,2);
            List<User> users=sqlSession.selectList("com.yw.dao.UserMapper.getUserByRowBounds",null,rowBounds);
            for (User user : users) {
                System.out.println(user);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }

    }

    @Test
    public void testlog4j(){
        logger.info("info===========");
        logger.debug("debug==========");
        logger.error("erroe===========");

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
