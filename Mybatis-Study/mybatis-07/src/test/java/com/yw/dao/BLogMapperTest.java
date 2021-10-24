package com.yw.dao;

import com.yw.pojo.BLog;
import com.yw.utils.IDUtils;
import com.yw.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BLogMapperTest {
    @Test
    public void queryBlogforeach(){
        SqlSession session= MyBatisUtil.getSqlSession();
        BLogMapper mapper=session.getMapper(BLogMapper.class);
        HashMap map=new HashMap();
        ArrayList<Integer> ids=new ArrayList<>();
        ids.add(1);
        ids.add(2);
        map.put("ids",ids);

        List<BLog> bLogs=mapper.queryBlogforeach(map);
        for (BLog bLog : bLogs) {
            System.out.println(bLog);
        }
    }

    @Test
    public void UpdateBlog(){
        SqlSession session= MyBatisUtil.getSqlSession();
        BLogMapper mapper=session.getMapper(BLogMapper.class);

        HashMap map=new HashMap();
        map.put("title","mybatis入门");
        map.put("id","a48ad51727b24ab6b83d775bc11aed30");
        mapper.UpdateBlog(map);
    }

    @Test
    public void queryBlogIF(){
        SqlSession session= MyBatisUtil.getSqlSession();
        BLogMapper mapper=session.getMapper(BLogMapper.class);

        HashMap map=new HashMap();
        map.put("title","spring");
        List<BLog> bLogs=mapper.queryBlogIF(map);
        for (BLog bLog : bLogs) {
            System.out.println(bLog);
        }
    }

    @Test
    public void addBook(){
        SqlSession session= MyBatisUtil.getSqlSession();
        BLogMapper mapper=session.getMapper(BLogMapper.class);

        BLog bLog=new BLog();
        bLog.setId(IDUtils.getId());
        bLog.setTitle("java基础入门");
        bLog.setAuthor("哗哗哗");
        bLog.setCreateTime(new Date());
        bLog.setViews(99999);

        mapper.addBook(bLog);

        bLog.setId(IDUtils.getId());
        bLog.setTitle("mybatis");
        mapper.addBook(bLog);

        bLog.setId(IDUtils.getId());
        bLog.setTitle("spring");
        mapper.addBook(bLog);

        bLog.setId(IDUtils.getId());
        bLog.setTitle("springcloud");
        mapper.addBook(bLog);

        session.close();
    }
}
