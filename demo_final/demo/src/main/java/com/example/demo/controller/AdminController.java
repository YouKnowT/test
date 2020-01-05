package com.example.demo.controller;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Competition;
import com.example.demo.entity.Teacher;
import com.example.demo.service.AdminService;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("index")
    public String toIndex(){
        return  "admin/adminIndex";
    }

    @GetMapping("/teacherManage")
    public String teacherManage(ModelMap modelMap) {
        List<Teacher> teachers = teacherService.findAll();
        modelMap.addAttribute("teachers", teachers);
        return "admin/teacherManage";
    }

    @GetMapping("/teacherAudit")
    public String teacherAudit(ModelMap modelMap) {
        try {
            List<Teacher> teacherList = teacherService.findAllByAudit(true);
            List<Teacher> teacherList1 = teacherService.findAllByAudit(false);
            modelMap.addAttribute("auditTeachers", teacherList);
            modelMap.addAttribute("unAuditTeachers", teacherList1);
            return "admin/teacherAudit";
        } catch (Exception e) {
            System.out.println("获取审核教师数据失败" + e);
            return "admin/teacherAudit";
        }
    }

    @GetMapping("/teacher/{id}")
    public String updateTeacher(@PathVariable("id") Long id) {
        try {
           if (null != id) {
                teacherService.findById(id);
            }
        } catch (Exception e) {
            System.out.println("获取教师数据失败" + e);
        }
        return "redirect:/admin/teacherAudit";
    }
//
    @GetMapping("/teacherInfo")
    public String teacherInfo(ModelMap modelMap) {
        return "admin/teacherInfo";
    }
//
//    @RequestMapping("findById")
//    @ResponseBody
//    public Admin findById(@RequestParam("id") long id){
//        Admin admin = null;
//        admin = adminService.findById(id);
//
//        return admin;
//    }
//    @RequestMapping("findCompetition")
//    @ResponseBody
//    public Competition findCompetition(HttpServletRequest request){
//        return null;
//    }


    @RequestMapping("saveCompetition")
    @ResponseBody
    public String saveCompetition(HttpServletRequest request){ return  null;}
//        Competition competition = new Competition();
//        competition.setCompetition_name(request.getParameter("competition_name"));
//        competition.setStudent_count(Long.parseLong(request.getParameter("student_num")));
//        competition.setStudent_name(request.getParameter("student_name"));
//        String category = request.getParameter("category");
//        if (category==null){
//            category = request.getParameter("category_others");
//        }
//        String level = request.getParameter("level");
//        if (level==null){
//            level= request.getParameter("level_others");
//        }
//        competition.setCategory(category);
//        competition.setItem(level);
//        competition.setStudent_guide(request.getParameter("competition_guide"));
//        competition.setStudent_class(request.getParameter("student_class"));
//        competitionService.saveCompetition(competition);
//        return "添加成功";
//    }



//    @RequestMapping("register")
//    @ResponseBody
//    public Map<Object, Object> registerAdmin(@RequestBody Map<Object,String> body){
//
//        Map<Object,Object> map = new HashMap<>();
//
//        Admin admin = new Admin();
//        admin.setId(Long.parseLong(body.get("id")));
//        admin.setPassword(body.get("password"));
//
//        admin.setPassword( EncodingHelper.encode( admin.getPassword() ) );
//
//        if(adminService.registerAdmin(admin) != null) {
//            map.put("result", "SUCCESS");
//        } else {
//            map.put("result", "FAILED");
//        }
//        return map;
//    }
//
//
}
