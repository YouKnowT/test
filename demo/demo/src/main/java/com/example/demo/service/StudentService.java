package com.example.demo.service;

import com.example.demo.entity.Student;

public interface StudentService {
    Student findById(long id);
    Student findByName(String name);
    Student findByUser_count(long user_count);
    Student registerStudent(Student student);



    Student addStudent(Student student);

    void updateStudent(Student student);

    void deleteByUser_count(long user_count);
}
