package com.example.demo.controller;


import com.example.demo.entity.Admin;
import com.example.demo.entity.Competition;
import com.example.demo.service.AdminService;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.StudentService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/admin")
public class AdminController {
//
//    @Autowired
//    private AdminService adminService;
//    @Autowired
//    private CompetitionService competitionService;
//    @Autowired
//    private StudentService studentService;
//    @Autowired
//    private TeacherService teacherService;
//
//    @RequestMapping("index")
//    public String toIndex(){
//        return  "admin/adminIndex";
//    }
//
//    @GetMapping("/teacherManage")
//    public String teacherManage(ModelMap modelMap) {
////        modelMap.addAllAttributes("teachers")
//        return "admin/teacherManage";
//    }
//
//    @GetMapping("/teacherAudit")
//    public String teacherAudit(ModelMap modelMap) {
//        return "admin/teacherAudit";
//    }
//
//    @GetMapping("/teacherInfo")
//    public String teacherInfo(ModelMap modelMap) {
//        return "admin/teacherInfo";
//    }
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
