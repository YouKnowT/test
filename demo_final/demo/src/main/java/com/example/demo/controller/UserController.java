package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import com.example.demo.util.EncodingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//package com.example.demo.controller;
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("toRegister")
    @ResponseBody
    public ModelAndView toRegister() {
        return new ModelAndView("register.html");
    }

    @RequestMapping("toLogin")
    @ResponseBody
    public ModelAndView toLogin() {
        return new ModelAndView("login.html");
    }

    @RequestMapping("register")
    @ResponseBody
    public ModelAndView register(HttpServletRequest request) {
        String category = request.getParameter("RadioGroup");
//        System.out.println(category);
        String user_account = request.getParameter("user_account");
        String user_name = request.getParameter("user_name");
        String user_pwd = request.getParameter("user_pwd");
        if (category.equals("0")) {
            System.out.println("教师");
            Teacher teacher = new Teacher();
            teacher.setUser_count(Long.parseLong(user_account));
//            teacher.setId(Long.parseLong(user_account));
            teacher.setName(user_name);
            teacher.setPassword(EncodingHelper.encode(user_pwd));
//            System.out.println(teacherService.registerTeacher(teacher));
//            System.out.println(teacher);
            if (teacherService.registerTeacher(teacher) != null) {
                System.out.println("SUCCESS!!");
                return new ModelAndView("redirect:/user/toLogin");
            } else {
                return new ModelAndView("redirect:/user/toRegister");
            }
        } else {
            Student student = new Student();
            System.out.println("学生");
            student.setUser_count(Long.parseLong(user_account));
            student.setName(user_name);
            student.setPassword(EncodingHelper.encode(user_pwd));
            if (studentService.registerStudent(student) != null) {
                return new ModelAndView("redirect:/user/toLogin");
            } else {
                return new ModelAndView("redirect:/user/toRegister");
            }
        }
    }

    @RequestMapping("login")
    @ResponseBody
    public ModelAndView login(HttpServletRequest request) {

        String category = request.getParameter("RadioGroup");
//        String user_account = request.getParameter("user_account");
        String user_account = request.getParameter("user_name");
        System.out.println(user_account);
        String user_pwd = request.getParameter("user_pwd");
        if (category.equals("0")) {
            System.out.println("教师");
            Teacher teacher = new Teacher();
            teacher.setUser_count(Long.parseLong(user_account));
//            teacher.setName(user_name);
            teacher.setPassword(EncodingHelper.encode(user_pwd));
            Teacher teacher2 = teacherService.findByUser_count(teacher.getUser_count());

            if (teacher2 != null) {
                if (teacher.getPassword().equals(teacher2.getPassword())) {
                    return new ModelAndView("index_teacher.html");
                }
            }
        } else if (category.equals("1")) {
            System.out.println("学生登录！");
            Student student = new Student();
            student.setUser_count(Long.parseLong(user_account));
//            student.setName(user_name);
            Student student2 = studentService.findByUser_account(student.getUser_count());
            System.out.println(student2);
            student.setPassword(EncodingHelper.encode(user_pwd));
            if (student2 != null) {
                if (student.getPassword().equals(student2.getPassword())) {
                    System.out.println("登录成功！");
                    return new ModelAndView("redirect:/student/toIndex?name=" + student.getUser_count());
                }
            }
        } else {
            System.out.println("管理员登录！");
            Admin admin = new Admin();
            admin.setName(user_account);
            Admin admin1 = adminService.findByName(admin.getName());
            admin.setPassword(EncodingHelper.encode(user_pwd));
            if (admin1 != null) {
                if (admin.getPassword().equals(EncodingHelper.encode(user_pwd))) {
                    return new ModelAndView("redirect:/admin/index");

//                    return new ModelAndView("redirect:/user/toLogin");
                }
//            }
            }
        }
        System.out.println("登录失败！");
        return new ModelAndView("redirect:/user/toLogin");
    }

}

//            if (admin1 != null) {
//                if (admin1.getPassword().equals(user_pwd)) {
//                    return new ModelAndView("index_teacher.html");
//                }
//                return new ModelAndView("redirect:/user/toLogin");
//            }
//        }
//        return new ModelAndView("redirect:/user/toLogin");
//    }
