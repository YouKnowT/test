package com.example.demo.controller;


import com.example.demo.entity.Competition;
import com.example.demo.entity.Student;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController{
    @Autowired
    private StudentService studentService;
    @Autowired
    private CompetitionService competitionService;
//    @RequestMapping(value = "toIndex",method = RequestMethod.GET)
//    @ResponseBody
////    public ModelAndView toIndex(@RequestParam("name") long name)
//    public ModelAndView passParam(Map <String, Object> map, @RequestParam("name") long name){


    @RequestMapping(value = "toIndex",method = RequestMethod.GET)
    @ResponseBody
//    public ModelAndView toIndex(@RequestParam("name") long name)
    public ModelAndView passParam(Map <String, Object> map, @RequestParam("userCount") long userCount){


        List<Competition> competitions = competitionService.findByStudent_count(userCount);

        map.put("competitions",competitions);

        ModelAndView mav = new ModelAndView("info_show");

        mav.addObject(map);
        return mav;
    }

//        ModelAndView mav = new ModelAndView("info_show");
//
//        mav.addObject(map);
//        return mav;


    @RequestMapping("findById")
    @ResponseBody
    public Student findById(@RequestParam("id") long id){
        Student student = null;

//        student = studentService.findById(id);

        return student;
    }

    @RequestMapping("findByName")
    @ResponseBody
    public Student findByName(@RequestParam("name") String name){
        Student student = null;
//        student = studentService.findByName(name);
//        System.out.println(student);
        return student;
    }
    @RequestMapping("findUserCount")
    @ResponseBody
    public Student findUserCount(@RequestParam("userCount") String userCount){
        Student student = null;
//        student = studentService.findByUser_account(Long.parseLong(userCount));
//        System.out.println(student);
        return student;
    }

    @RequestMapping("deleteByUser_count")
    @ResponseBody
    public void deleteByUser_count(@RequestParam("user_count") long user_count){
//        studentService.deleteByUser_count(user_count);
    }

    @RequestMapping("addStudent")
    @ResponseBody
    public Student addStudent(@RequestParam("student") Student student){

//        return studentService.addStudent(student);
        return null;
    }

    @RequestMapping("updateStudent")
    @ResponseBody
    public void updateStudent(@RequestParam("student") Student student){
//        studentService.updateStudent(student);
    }


//    @RequestMapping("register")
//    @ResponseBody
//    public Map<Object, Object> registerStudent(@RequestBody Map<Object,String> body){
//
//        Map<Object,Object> map = new HashMap<>();
//
//        Student student = new Student();
//        student.setId(Long.parseLong(body.get("id")));
//        student.setPassword(body.get("password"));
//
//        student.setPassword( EncodingHelper.encode( student.getPassword() ) );
//
//        if(studentService.registerStudent(student) != null) {
//            map.put("result", "SUCCESS");
//        } else {
//            map.put("result", "FAILED");
//        }
//        return map;
//    }
}


