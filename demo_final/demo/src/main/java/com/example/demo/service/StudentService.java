package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

public interface StudentService {
//    Student findById(long id);
//    Student findByName(String name);
    Student findByUserAccount(long userAccount);
    Student registerStudent(Student student);
    List<Student> findAll();

    void updateStudent(Student student);

    void deleteById(Long id);
//    void updateStudent(Student student);
//    Student addStudent(Student student);
//    void deleteByUser_count(long user_count);
}
