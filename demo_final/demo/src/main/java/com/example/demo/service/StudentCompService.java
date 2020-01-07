package com.example.demo.service;

import com.example.demo.entity.StudentComp;

import java.util.List;

public interface StudentCompService {

    StudentComp save(StudentComp studentComp);
    List<StudentComp> findAll();
    List<StudentComp> findByComId(Long id);
    List<StudentComp> findByStudentId(Long id);
}
