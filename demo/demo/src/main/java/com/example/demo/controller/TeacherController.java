package com.example.demo.controller;

import com.example.demo.entity.Teacher;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
        @Autowired
        private TeacherService teacherService;
        @Autowired
        private StudentService studentService;
//对教师表进行操作
        @RequestMapping("test")
        @ResponseBody
        public String toIndex(){
            return "Test";
        }
        @RequestMapping("toTeacherV1")
        @ResponseBody
        public ModelAndView toTeacherV1(){
            return new ModelAndView("index_teacher_v1.html");
        }
        @RequestMapping("findByUser_count")
        @ResponseBody
        public Teacher findByUser_count(@RequestParam("user_count") long user_count){
            Teacher teacher = null;
            teacher = teacherService.findByUser_count(user_count);
            return teacher;
        }
        @RequestMapping("findByName")
        @ResponseBody
        public Teacher findByName(@RequestParam("name") String name){
            Teacher teacher = null;
            teacher = teacherService.findByName(name);
            return teacher;
        }
        @RequestMapping("updateTeacher")
        @ResponseBody
        public void updateTeacher(@RequestParam("user_count,name,password") long user_count,String name,String password){
            teacherService.updateTeacher(user_count,name,password);
        }
        @RequestMapping("deleteByUser_count")
        @ResponseBody
        public void deleteByUser_count(@RequestParam("user_count") long user_count){
            teacherService.deleteByUser_count(user_count);
        }
        @RequestMapping("addTeacher")
        @ResponseBody
        public Teacher addTeacher(@RequestParam("teacher") Teacher teacher){
            return teacherService.addTeacher(teacher);
        }

    //对学生表进行操作

}
