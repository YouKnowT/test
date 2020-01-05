package com.example.demo.service;
import com.example.demo.entity.Teacher;


public interface TeacherService {

//    Teacher findById(long id);
    Teacher findByUserAccount(long userAccount);
//    Teacher findByName(String name);
    Teacher registerTeacher(Teacher teacher);
//    void updateTeacher(Teacher teacher);
//    Teacher addTeacher(Teacher teacher);
//    void deleteByUser_count(long user_count);
}
