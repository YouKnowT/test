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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

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

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
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
            teacher.setUserAccount(Long.parseLong(user_account));
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
            student.setUserCount(Long.parseLong(user_account));
            student.setName(user_name);
            student.setPassword(EncodingHelper.encode(user_pwd));
            if (studentService.registerStudent(student) != null) {
                return new ModelAndView("redirect:/user/toLogin");
            } else {
                return new ModelAndView("redirect:/user/toRegister");
            }
        }
    }

//    @PostMapping("/register")
//    public String register(HttpServletRequest request) {
//        String category = request.getParameter("RadioGroup");
//        System.out.println(category);
//        String userAccount = request.getParameter("user_account");
//        String userName = request.getParameter("user_name");
//        String userPwd = request.getParameter("user_pwd");
//        if (category.equals("0")) {
//            System.out.println("教师");
//            Teacher teacher = new Teacher();
//            teacher.setUserAccount(Long.parseLong(userAccount));
//            teacher.setId(Long.parseLong(userAccount));
//            teacher.setName(userName);
//            Date date = new Date();
//            teacher.setCreateTime(date);
//            teacher.setUpdateTime(date);
//            teacher.setPassword(EncodingHelper.encode(userPwd));
//            teacher.setAudit(false);
//            System.out.println(teacher);
//            if (teacherService.registerTeacher(teacher) != null) {
//                System.out.println("SUCCESS!!");
//                return "redirect:/user/toLogin";
//            } else {
//                return "redirect:/user/toRegister";
//            }
//        } else {
//            Student student = new Student();
//            System.out.println("学生");
//            student.setUserCount(Long.parseLong(userAccount));
//            student.setName(userName);
//            student.setPassword(EncodingHelper.encode(userPwd));
//            if (studentService.registerStudent(student) != null) {
//                return "redirect:/user/toLogin";
//            } else {
//                return "redirect:/user/toRegister";
//            }
//        }
//    }

//

    @RequestMapping("login")
    @ResponseBody
    public ModelAndView login(HttpServletRequest request) {

        String category = request.getParameter("RadioGroup");
       String user_account = request.getParameter("user_account");
        //String user_account = request.getParameter("user_name");
        System.out.println(user_account);
        String user_pwd = request.getParameter("password");
        if (category.equals("0")) {
            System.out.println("教师");
            Teacher teacher = new Teacher();
            teacher.setUserAccount(Long.parseLong(user_account));
//            teacher.setName(user_name);
            teacher.setPassword(EncodingHelper.encode(user_pwd));
            Teacher teacher2 = teacherService.findByUserAccount(teacher.getUserAccount());

            if (teacher2 != null) {
                if (teacher.getPassword().equals(teacher2.getPassword())) {
                    return new ModelAndView("index_teacher.html");
                }
            }
        } else if (category.equals("1")) {
            System.out.println("学生登录！");
            Student student = new Student();
            student.setUserCount(Long.parseLong(user_account));
//            student.setName(user_name);
            Student student2 = studentService.findByUserAccount(student.getUserCount());
            System.out.println(student2);
            student.setPassword(EncodingHelper.encode(user_pwd));
            if (student2 != null) {
                if (student.getPassword().equals(student2.getPassword())) {
                    System.out.println("登录成功！");
                    return new ModelAndView("redirect:/student/toIndex?name=" + student.getUserCount());
                }
            }
        } else {
            System.out.println("管理员登录！");
//            Admin admin = new Admin();
//            admin.setName(user_account);
//            Admin admin1 = adminService.findByName(admin.getName());
//            admin.setPassword(EncodingHelper.encode(user_pwd));
//            if (admin1 != null) {
            if ("Qw1".equals(user_pwd) && "123".equals(user_account)) {
//                return new ModelAndView("index_admin.html");

                    return new ModelAndView("admin/competeManage.html");
            }
//            }
        }
        System.out.println("登录失败！");
        return new ModelAndView("redirect:/user/toLogin");
    }
}

