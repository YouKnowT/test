package com.example.demo.controller;


import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.util.EncodingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/index")
    public String toIndex(){
        return  "admin/adminIndex";
    }

    @ResponseBody
    @GetMapping("/indexData")
    public Object indexData() {
        try {
            List<Teacher> teachers = teacherService.findAll();
            List<Student> students = studentService.findAll();
            List<Competition> competitions = competitionService.findAll();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("teachers", teachers);
            map.put("students", students);
            map.put("competitions", competitions);
            return  map;
        } catch (Exception e) {
            System.out.println("获取管理员首页错误" + e);
            return "失败";
        }


    }

    @GetMapping("/teacherManage")
    public String teacherManage(ModelMap modelMap) {
        try {
            List<Teacher> teachers = teacherService.findAll();
            modelMap.addAttribute("teachers", teachers);
            return "admin/teacherManage";
        } catch (Exception e) {
            System.out.println("教师管理数据请求失败" + e);
        }
       return "500";
    }

    @GetMapping("/teacherEdit/{id}")
    public String teacherEdit(@PathVariable("id") Long id, ModelMap modelMap) {
        try {
            Teacher teacher = teacherService.findById(id);
            modelMap.addAttribute("teacher", teacher);
            return "admin/editTeacher";
        } catch (Exception e) {
            System.out.println("修改教师数据请求失败" + e);
        }
       return "500";
    }

    @PostMapping("/updateTeacher")
    public String updateTeacher(Teacher teacher) {
        try {
            teacher.setUpdateTime(new Date());
            Teacher teacher1 = teacherService.findById(teacher.getId());
            teacher.setCompetitions(teacher1.getCompetitions());
            teacher.setPassword(EncodingHelper.encode(teacher.getPassword()));
            teacherService.updateTeacher(teacher);
            return "redirect:/admin/teacherManage";
        } catch (Exception e) {
            System.out.println("获取教师数据失败" + e);
        }
        return "500";
    }

    @GetMapping("/teacherDel/{id}")
    public String delTeacher(@PathVariable("id") Long id) {
        try {
            if (null != id) {
                teacherService.deleteById(id);
            }
            return "redirect:/admin/teacherManage";
        } catch (Exception e) {
            System.out.println("删除失败" + e);
        }
        return "500";
    }

    @GetMapping("/competeManage")
    public String competition(ModelMap modelMap) {
        try {
            List<Competition> competitions = competitionService.findAll();
            modelMap.addAttribute("competitions", competitions);
            return "admin/competeManage";
        } catch (Exception e) {
            System.out.println("比赛管理数据请求失败" + e);
        }
        return "500";
    }

    @GetMapping("/addCompetition")
    public String addCompetition(ModelMap modelMap) {
        try {
            List<Category> categories = categoryService.findAll();
            List<Teacher> teachers = teacherService.findAll();
            modelMap.addAttribute("teachers", teachers);
            modelMap.addAttribute("categories", categories);
            return "admin/addCompetition";
        } catch (Exception e) {
            System.out.println("添加比赛页面数据加载失败" + e);
        }
        return "500";
    }

    @PostMapping("/competitionAdd")
    public String competition1Add(@RequestParam("certificate") MultipartFile file, HttpServletRequest request) {
        try {
            String name = request.getParameter("name");
            String category = request.getParameter("category");
            String level = request.getParameter("level");
            long teacherId = Long.parseLong(request.getParameter("teacherId"));
            Teacher teacher = teacherService.findById(teacherId);
            String startTime = request.getParameter("startTime");
            Competition competition = new Competition();
            competition.setName(name);
            competition.setCategory(category);
            competition.setLevel(level);
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            competition.setStartTime(dateFormat.parse(startTime));
            competition.setTeacherId(teacherId);
            competition.setTeacherName(teacher.getName());
            String path = "c:/uploadPath";
            File file1 = new File(path);
            if (!file1.exists() && !file1.isDirectory()) {
                file1.mkdirs();
            }
            new File(file1, file.getOriginalFilename());
            competition.setCertificate("/picture/" + file.getOriginalFilename());
            System.out.println(competition);
            competitionService.save(competition);
            return "redirect:/admin/competeManage";
        } catch (Exception e) {
            System.out.println("添加比赛失败" + e);
        }
        return "500";
    }

    @GetMapping("/delCompetition/{id}")
    public String delCompetition(@PathVariable("id") Long id) {
        try {
            if (id != null) {
                competitionService.deleteById(id);
            }
            return "redirect:/admin/competeManage";
        } catch (Exception e) {
            System.out.println("删除失败" + e);
        }
        return "500";
    }

//    @GetMapping("/teacherAudit")
//    public String teacherAudit(ModelMap modelMap) {
//        try {
//            List<Teacher> teacherList = teacherService.findAllByAudit(true);
//            List<Teacher> teacherList1 = teacherService.findAllByAudit(false);
//            modelMap.addAttribute("auditTeachers", teacherList);
//            modelMap.addAttribute("unAuditTeachers", teacherList1);
//            return "admin/teacherAudit";
//        } catch (Exception e) {
//            System.out.println("获取审核教师数据失败" + e);
//            return "admin/teacherAudit";
//        }
//    }
//
//
////
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
