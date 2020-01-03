package com.example.demo.service;
import com.example.demo.entity.Teacher;


public interface TeacherService {

    Teacher findById(long id);
    Teacher findByUser_count(long user_count);
    Teacher findByName(String name);
    Teacher registerTeacher(Teacher teacher);

    void updateTeacher(long user_count,String name,String password);



    Teacher addTeacher(Teacher teacher);

    void deleteByUser_count(long user_countd);

    //Teacher findByUser_count(String user_count);
}
