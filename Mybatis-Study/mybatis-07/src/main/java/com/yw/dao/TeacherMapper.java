package com.yw.dao;

import com.yw.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //获取指定老师下的所有学生及老师的信息
    List<Teacher> getTeacherAll2(@Param("tid")int id);

    List<Teacher> getTeacherAll(@Param("tid")int id);

    List<Teacher> getAll();

    @Select("select * from teacher where id=#{tid}")
    Teacher getTeacher(@Param("tid") int id);
}
