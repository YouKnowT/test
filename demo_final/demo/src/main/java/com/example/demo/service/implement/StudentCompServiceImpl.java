package com.example.demo.service.implement;

import com.example.demo.entity.StudentComp;
import com.example.demo.repository.StudentCompDao;
import com.example.demo.service.StudentCompService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentCompServiceImpl implements StudentCompService {

    @Autowired
    private StudentCompDao studentCompDao;

    @Override
    public StudentComp save(StudentComp studentComp) {
        return studentCompDao.save(studentComp);
    }

    @Override
    public List<StudentComp> findAll() {
        return studentCompDao.findAll();
    }

    @Override
    public List<StudentComp> findByComId(Long id) {
        return studentCompDao.findByComId(id);
    }

    @Override
    public List<StudentComp> findByStudentId(Long id) {
        return studentCompDao.findByStudentId(id);
    }
}
