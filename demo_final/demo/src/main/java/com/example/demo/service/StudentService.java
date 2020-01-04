package com.example.demo.service;

import com.example.demo.entity.Student;

public interface StudentService {
    Student findById(long id);
    Student findByName(String name);
    Student findByUser_account(long user_count);
    Student registerStudent(Student student);
    Student findAll();
    void updateStudent(Student student);
    Student addStudent(Student student);
    void deleteByUser_count(long user_count);
}
