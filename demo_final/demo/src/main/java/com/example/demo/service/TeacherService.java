package com.example.demo.service;
import com.example.demo.entity.Teacher;

import java.util.List;


public interface TeacherService {

    Teacher findById(long id);
    Teacher findByUserAccount(long userAccount);
    List<Teacher> findAllByAudit(Boolean audit);
    List<Teacher> findAll();
//    Teacher findByName(String name);
    Teacher registerTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
//    Teacher addTeacher(Teacher teacher);
    void deleteById(long id);
}
