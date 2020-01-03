package com.example.demo.controller;


import com.example.demo.entity.Admin;
import com.example.demo.entity.Competition;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.AdminService;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import com.example.demo.util.EncodingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private CompetitionService competitionService;


//    @RequsetMapping("toModify")
//    @RequestBody
//    public ModelAndView toModify(){
//
//    }
    @RequestMapping("toModifyTeacher")
    @ResponseBody
    public ModelAndView toModifyTeacher(){
        return new ModelAndView("admin_info_teacher.jsp");
    }

    @RequestMapping("toModifyStu")
    @ResponseBody
    public ModelAndView toModifyStu(){
        return new ModelAndView("admin_info_stu.jsp");
    }

    @RequestMapping("toModifyCompetition")
    @ResponseBody
    public ModelAndView toModifyCompetition(){
        return new ModelAndView("admin_add_info.html");
    }


    @RequestMapping("toModify")
    @ResponseBody
    public ModelAndView toModify(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index_admin.html");
        String category = request.getParameter("MenuItem");
        String name = request.getParameter("name");
        long user_count = Long.parseLong(request.getParameter("user_count"));
        String password = request.getParameter("password");

        if(category.equals("0")) {
            Teacher teacher = new Teacher();
            teacher.setUser_count(user_count);
            teacher.setPassword(EncodingHelper.encode(password));
            Teacher teacher2 = teacherService.findByUser_count(teacher.getUser_count());
            if (teacher2 != null) {
                String category0 = request.getParameter("but");
                if (category0.equals("0")) {
                    modelAndView.setViewName("teacher_modify.jsp");
                    String category1 = request.getParameter("but");
                    if (category1.equals("0")) {
                        teacher2.setUser_count(user_count);
                        teacher2.setName(name);
                        teacher2.setPassword(password);
                        teacherService.updateTeacher(user_count,name,password);
                    }
                    return new ModelAndView("redirect:/admin/toModifyTeacher");
                } else {
                    teacherService.deleteByUser_count(user_count);
                    return new ModelAndView("redirect:/admin/toModifyTeacher");
                }
            }
            else
                return new ModelAndView("redirect:/admin/toModifyTeacher");
            //teacher=teacherService.findByUser_count(user_count);
        }
        else if(category.equals("1")){
            Student student=null;
            student = studentService.findByUser_count(user_count);
            String category0 = request.getParameter("but");
            if(category0.equals("0")){
                modelAndView.addObject("stu_modify.jsp",student);
                String category1 = request.getParameter("but");
                if(category1.equals("0")){
                    studentService.updateStudent(student);
                }
                return new ModelAndView("redirect:toModifyStu");
            }else{
//                modelAndView.addObject("stu_modify.jsp",student);
//                String category1 = request.getParameter("but");
//                if(category1.equals("0")){
//                }
                studentService.deleteByUser_count(user_count);
                return new ModelAndView("redirect:toModifyStu");
            }
        }
        else if (category.equals("2")){
            String item = request.getParameter("item");
            String categorys=request.getParameter("categorys");
            String category0 = request.getParameter("but");
            Competition competition = null;
            competition = competitionService.findBySuser_countAndCategorysAndItem(user_count,categorys,item);
            if (category0.equals("0")){

                modelAndView.addObject("match_modify.jsp",competition);
                competitionService.updateCompetition(competition);
                return new ModelAndView("redirect:/admin/toMatchModify");
            }else{
//                modelAndView.addObject("match_modify.jsp",competition);
                competitionService.deleteCompetitionByCategorysAndItemAndSuser_count(user_count,categorys,item);
                return new ModelAndView("redirect:/admin/toMatchModify");
            }
        }
        else if (category.equals("3")){

            return new ModelAndView("para_modify.jsp");
        }
        else{
            return new ModelAndView("output.jsp");
        }
    }


//    @RequestMapping("toExcelSomething")
//    @ResponseBody
//    public ModelAndView toExcelSomething(HttpServletRequest request){
//
//        return new ModelAndView("output.jsp");
//    }


    @RequestMapping("test")
    @ResponseBody
    public ModelAndView toIndex(){
        ModelAndView mav = new ModelAndView("register.html");
        return  mav;
    }
    //对管理员的操作
    @RequestMapping("toAdmin")
    @ResponseBody
    public ModelAndView toAdmin(){
        return new ModelAndView("index_admin_v1.jsp");
    }
    @RequestMapping("findById")
    @ResponseBody
    public Admin findById(@RequestParam("id") long id){
        Admin admin = null;
        admin = adminService.findById(id);
        return admin;
    }

}
