package com.yw.dao;

import com.yw.pojo.Student;
import com.yw.pojo.Teacher;
import com.yw.pojo.User;
import com.yw.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest {
    @Test
    public void testCache(){
        SqlSession session= MyBatisUtil.getSqlSession();
        SqlSession session2= MyBatisUtil.getSqlSession();

        UserMapper mapper=session.getMapper(UserMapper.class);
        UserMapper mapper2=session.getMapper(UserMapper.class);

        User user= mapper.queryUserById(1);
        System.out.println(user);

        System.out.println("==========================");

        User user2= mapper2.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        session.close();
        session2.close();
    }


    @Test
    public void queryUserById(){
        SqlSession session= MyBatisUtil.getSqlSession();
        UserMapper mapper=session.getMapper(UserMapper.class);
        User user= mapper.queryUserById(1);
        System.out.println(user);

        System.out.println("==========================");

        User user2= mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);

        session.close();
    }

    @Test
    public void getTeacher(){
        SqlSession session= MyBatisUtil.getSqlSession();
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        Teacher teacher= teacherMapper.getTeacher(1);
        session.close();
        System.out.println(teacher);
    }

    @Test
    public void getTeacherAll(){
        SqlSession session= MyBatisUtil.getSqlSession();
        TeacherMapper teacherMapper=session.getMapper(TeacherMapper.class);
        List<Teacher> teachers= teacherMapper.getTeacherAll2(1);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        session.close();

    }

    @Test
    public void getStudent(){
        SqlSession session= MyBatisUtil.getSqlSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);
        List<Student> students= studentMapper.getStudent();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();

    }

    @Test
    public void getStudent2(){
        SqlSession session= MyBatisUtil.getSqlSession();
        StudentMapper studentMapper=session.getMapper(StudentMapper.class);
        List<Student> students= studentMapper.getStudent2();
        for (Student student : students) {
            System.out.println(student);
        }
        session.close();

    }

}
