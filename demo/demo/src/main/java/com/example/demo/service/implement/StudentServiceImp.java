package com.example.demo.service.implement;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentDao;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public Student findById(long id){
        return studentDao.findById(id);
    }
    @Override
    public Student findByUser_count(long user_count){return studentDao.findByUser_count(user_count);}
    @Override
    public Student findByName(String name){
        return studentDao.findByName(name);
    }
    @Override
    public Student registerStudent(Student student){
        return studentDao.save(student);
    }

//    @Override
//    public void deleteById(long id) {
//        studentDao.deleteById(id);
//    }

    @Override
    public Student addStudent(Student student) {
        return studentDao.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteByUser_count(long user_count) {
        studentDao.deleteByUser_count(user_count);
    }
}
