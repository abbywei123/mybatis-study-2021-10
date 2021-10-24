package com.yw.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//SqlSessionFactory 获取 SqlSession
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resorce="mybatis-config.xml";
        try {
            //获取 SqlSessionFactory
            InputStream inputStream= Resources.getResourceAsStream(resorce);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}
