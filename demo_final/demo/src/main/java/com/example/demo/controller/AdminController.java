package com.example.demo.controller;


import com.example.demo.entity.*;
import com.example.demo.service.*;
import com.example.demo.util.EncodingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    private StudentCompService studentCompService;

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

    @GetMapping("/studentManage")
    public String studentManage(ModelMap modelMap) {
        try {
            List<Student> students = studentService.findAll();
            modelMap.addAttribute("students", students);
            return "admin/studentManage";
        } catch (Exception e) {
            System.out.println("学生管理数据请求失败" + e);
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

    @GetMapping("/studentEdit/{id}")
    public String studentEdit(@PathVariable("userAccount") Long userAccount, ModelMap modelMap) {
        try {
            Student student = studentService.findByUserAccount(userAccount);
            modelMap.addAttribute("student", student);
            return "admin/editStudent";
        } catch (Exception e) {
            System.out.println("修改学生数据请求失败" + e);
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

    @PostMapping("/updateStudent")
    public String updateStudent(Student student) {
        try {
            //student.setUpdateTime(new Date());
            Student student1 = studentService.findByUserAccount(student.getId());
            student.setPassword(EncodingHelper.encode(student.getPassword()));
            studentService.updateStudent(student);
            return "redirect:/admin/teacherManage";
        } catch (Exception e) {
            System.out.println("获取学生数据失败" + e);
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

    @GetMapping("/studentDel/{id}")
    public String delStudent(@PathVariable("id") Long id) {
        try {
            if (null != id) {
                studentService.deleteById(id);
            }
            return "redirect:/admin/studentManage";
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

    @GetMapping("/competitionEdit/{id}")
    public String competitionEdit(@PathVariable("id") Long id, ModelMap modelMap) {
        try {
            Competition competition =  competitionService.findById(id);
            List<Category> categories = categoryService.findAll();
            List<Teacher> teachers = teacherService.findAll();
            modelMap.addAttribute("competition", competition);
            modelMap.addAttribute("categories", categories);
            modelMap.addAttribute("teachers", teachers);
            return "admin/editCompetition";
        } catch (Exception e) {
            System.out.println(e);
        }
        return "500";
    }

    @PostMapping("/updateCompetition")
    public String updateCompetition(Competition competition) {
        try {
            Competition competition1 = competitionService.findById(competition.getId());
            competition.setCertificate(competition1.getCertificate());
            Teacher teacher = teacherService.findById(competition.getTeacherId());
            competition.setTeacherName(teacher.getName());
            competitionService.updateCompetition(competition);
            return "redirect:/admin/competeManage";
        } catch (Exception e) {
            System.out.println("获取学生数据失败" + e);
        }
        return "500";
    }

    // 添加参赛学生
    @GetMapping("/addComStudent/{id}")
    public String addComStudent(@PathVariable("id") Long id, ModelMap modelMap) {
        try {
            List<Student> students = studentService.findAll();
            Competition competition = competitionService.findById(id);
            modelMap.addAttribute("students", students);
            modelMap.addAttribute("competition", competition);
            return "admin/addComStudent";
        } catch (Exception e) {
            System.out.println("添加参赛学生页面失败" + e);
        }
        return "500";
    }

    @PostMapping(value = "/compStudentAdd")
    public String compStudentAdd(HttpServletRequest request) {
        try {
            Long comId = Long.parseLong( request.getParameter("comId"));
            Long studentId = Long.parseLong(request.getParameter("studentId"));
            if (comId != null && studentId != null) {
                StudentComp studentComp = new StudentComp();
                studentComp.setComId(comId);
                studentComp.setStudentId(studentId);
                studentCompService.save(studentComp);
            }
            return "redirect:/admin/competeManage";
        } catch (Exception e) {
            System.out.println("添加比赛学生失败" + e);
        }
        return "500";
    }

    @GetMapping(value = "/competitionDetail/{id}")
    public String competitionDetail(@PathVariable("id") Long id, ModelMap modelMap) {
        try {
            List<StudentComp> studentComps = studentCompService.findByComId(id);
            Competition competition = competitionService.findById(id);
            List<Student> students = new ArrayList<>();
            for(StudentComp sc: studentComps) {
                students.add(studentService.findById(sc.getStudentId()));
            }
            modelMap.addAttribute("competition", competition);
            modelMap.addAttribute("students", students);
            return "admin/detailCompetition";
        } catch (Exception e) {
            System.out.println(e);
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
