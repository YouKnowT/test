package com.example.demo.controller;

import com.example.demo.entity.Competition;
import com.example.demo.entity.Teacher;
import com.example.demo.service.CompetitionService;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

        @Autowired
        private TeacherService teacherService;

      @Autowired
        private CompetitionService competitionService;
        @RequestMapping("showAllCompetition")
        @ResponseBody
        public ModelAndView passParam(Map<String, Object> map){


            ModelAndView mav = new ModelAndView("info_show");

            mav.addObject(map);
            return mav;
        }
        @RequestMapping("toSave")
        @ResponseBody
        public ModelAndView toIndex(){

            return new ModelAndView("teacher_add_info.html");
        }
        @RequestMapping("toTeacherV1")
        @ResponseBody
        public ModelAndView toTeacherV1(){
            return new ModelAndView("index_teacher_v1.html");
        }
        @RequestMapping("findById")
        @ResponseBody
        public Teacher findById(@RequestParam("id") long id){
            Teacher teacher = new Teacher();
            teacher = teacherService.findById(id);
            return teacher;
        }

        @RequestMapping("saveCompetition")
        @ResponseBody
        public String saveCompetition(HttpServletRequest request){
            Competition competition = new Competition();
            competition.setName(request.getParameter("name"));
            competition.setStudent_count(Long.parseLong(request.getParameter("student_num")));
            competition.setStudent_name(request.getParameter("student_name"));
            String category = request.getParameter("category");

            if (category==null){
                category = request.getParameter("category_others");
            }
            String level = request.getParameter("level");
            if (level==null){
                 level= request.getParameter("level_others");
            }
            competition.setCategory(category);
            competition.setLevel(level);
            competition.setTeacherId(Long.parseLong(request.getParameter("competition_guide")));
            //competition.setStudent_class(request.getParameter("student_class"));

            //TeacherController competitionService;
            competitionService.saveCompetition(competition);

            return "添加成功";
        }

}
