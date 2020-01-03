package com.example.demo.service.implement;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherDao;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teacherService")
public class TeacherServiceImp implements TeacherService {
    @Autowired
    TeacherDao teacherDao;

    @Override
    public Teacher findById(long id){

        return teacherDao.findById(id);
    }
    @Override
    public Teacher findByUser_count(long user_count){
        return teacherDao.findByUser_count(user_count);
    }
    @Override
    public Teacher findByName(String name){
        return teacherDao.findByName(name);
    }
    @Override
    public Teacher registerTeacher(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    @Override
    public void updateTeacher(long user_count,String name,String password) {
        teacherDao.updateTeacher(user_count,name,password);
    }


    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherDao.save(teacher);
    }

    @Override
    public void deleteByUser_count(long user_count) {
        teacherDao.deleteByUser_count(user_count);

    }



}
