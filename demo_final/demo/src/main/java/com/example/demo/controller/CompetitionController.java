package com.example.demo.controller;

import com.example.demo.entity.Competition;
import com.example.demo.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/competition")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;
    @RequestMapping("test")
    @ResponseBody
    public String toIndex(){
        return "Test";
    }


    @RequestMapping("findById")
    @ResponseBody
    public Competition findById(@RequestParam("id") long id){
        Competition competition = null;
        competition = competitionService.findById(id);
        return competition;
    }

    @RequestMapping("findByCategory")
    @ResponseBody
    public List<Competition> findByCategory(@RequestParam("category") String category){
        return competitionService.findByCategory(category);
    }

    @RequestMapping("findByItem")
    @ResponseBody
    public  List<Competition> findByItem(@RequestParam("item") String item){
        List<Competition> competitionList = competitionService.findByItem(item);
        return competitionList;
    }
    @RequestMapping("updateCompetition")
    @ResponseBody
    public void updateCompetition(@RequestParam("competition") Competition competition){
        competitionService.updateCompetition(competition);
    }

    @RequestMapping("addCompetition")
    @ResponseBody
    public Competition addCompetition(@RequestParam("competition") Competition competition){
        return competitionService.addCompetition(competition);
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public void deleteById(@RequestParam("id") long id){
        competitionService.deleteById(id);
    }
}
