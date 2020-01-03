package com.example.demo.controller;


import com.example.demo.entity.Competition;
import com.example.demo.entity.Student;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CompetitionService competitionService;
    @RequestMapping("toIndex")
    @ResponseBody
    public ModelAndView toIndex(HttpServletRequest request){
        System.out.println(request.getParameter("name"));
        Competition competition = null;
        competition = competitionService.findById(Long.parseLong(request.getParameter("name")));
        return new ModelAndView("info_show.html");
    }

    @RequestMapping("findByUser_count")
    @ResponseBody
    public Student findByUser_count(@RequestParam("user_count") long user_count){
        Student student = null;
        return student;
    }

    @RequestMapping("findByName")
    @ResponseBody
    public Student findByName(@RequestParam("name") String name){
        Student student = null;
        student = studentService.findByName(name);
        return student;
    }
    @RequestMapping("deleteByUser_count")
    @ResponseBody
    public void deleteByUser_count(@RequestParam("user_count") long user_count){
        studentService.deleteByUser_count(user_count);
    }

    @RequestMapping("addStudent")
    @ResponseBody
    public Student addStudent(@RequestParam("student") Student student){
        return studentService.addStudent(student);
    }

    @RequestMapping("updateStudent")
    @ResponseBody
    public void updateStudent(@RequestParam("student") Student student){
        studentService.updateStudent(student);
    }


}


