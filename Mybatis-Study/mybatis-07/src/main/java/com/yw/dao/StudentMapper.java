package com.yw.dao;

import com.yw.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有学生的信息，以及对应的老师信息
    List<Student> getStudent();

    List<Student> getStudent2();
}
