package com.yw.dao;

import com.yw.pojo.BLog;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

public interface BLogMapper {
    int addBook(BLog bLog);

    List<BLog> queryBlogIF(Map map);

    List<BLog> queryBlogChoose(Map map);

    int UpdateBlog(Map map);

    List<BLog> queryBlogforeach(Map map);
}
