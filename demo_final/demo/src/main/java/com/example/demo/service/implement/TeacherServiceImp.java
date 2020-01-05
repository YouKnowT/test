package com.example.demo.service.implement;

import com.example.demo.entity.Teacher;
import com.example.demo.repository.TeacherDao;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImp implements TeacherService {
    @Autowired
    TeacherDao teacherDao;
//
    @Override
    public Teacher findById(long id){
        return teacherDao.findById(id);
    }

    @Override
    public Teacher findByUserAccount(long userAccount) {
        return teacherDao.findByUserAccount(userAccount);
    }

    @Override
    public List<Teacher> findAllByAudit(Boolean audit) {
        return teacherDao.findAllByAudit(audit);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherDao.findAll();
    }

    //    @Override
//    public Teacher findByName(String name){
//        return teacherDao.findByName(name);
//    }
    @Override
    public Teacher registerTeacher(Teacher teacher) {
        return teacherDao.save(teacher);
    }

//
//    @Override
//    public void updateTeacher(Teacher teacher) {
//        teacherDao.updateTeacher(teacher);
//    }
//
//    @Override
//    public Teacher addTeacher(Teacher teacher) {
//        return teacherDao.save(teacher);
//    }
//
//    @Override
//    public void deleteByUser_count(long user_count) {
//        teacherDao.deleteByUser_count(user_count);
//    }

}
