package com.example.demo.service.implement;


import com.example.demo.entity.Competition;
import com.example.demo.repository.CompetitionDao;
import com.example.demo.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("competitionService")
public class CompetitionServiceImp implements CompetitionService {
    @Autowired
    CompetitionDao competitionDao;

    @Override
    public Competition findById(long id) {
        return competitionDao.findById(id);
    }

    //    @Override
//    public Competition findById(long id){
//        return competitionDao.findById(id);
//    }
//    @Override
//    public List<Competition> findByCategory(String category){
//        return competitionDao.findByCategory(category);
//    }
//    @Override
//    public List<Competition> findByItem(String item){
//        return competitionDao.findByItem(item);
//    }
////
////    @Override
////    public List<Competition> findByName(String name) {
////        return competitionDao.findByName(name);
////    }
//
//
//    @Override
//    public List<Competition> findByNum(long num) {
//        return competitionDao.findByNum(num);
//    }
//
    @Override
    public List<Competition> findAll() {
        return competitionDao.findAll();
    }

    @Override
    public Competition save(Competition competition) {
        return competitionDao.save(competition);
    }

    @Override
    public Competition saveCompetition(Competition competition) {
        return competitionDao.save(competition);
    }

    @Override
    public void deleteById(long id) {
        competitionDao.deleteById(id);
    }

    @Override
    public void updateCompetition(Competition competition) {
        competitionDao.saveAndFlush(competition);
    }

    @Override
    public List<Competition> findByStudent_name(String student_name) {
        return competitionDao.findByStudent_name(student_name);
    }

    @Override
    public List<Competition> findByStudent_count(long student_count) {
        return competitionDao.findByStudent_count(student_count);
    }
//    public Competition saveCompetition(Competition competitionItem){
//        return competitionDao.save(competitionItem);
//    }
//
//    @Override
//    public void updateCompetition(Competition competition) {
//        competitionDao.updateCompetition(competition);
//    }
//
//    @Override
//    public void deleteById(long id) {
//        competitionDao.deleteById(id);
//    }
//
//    @Override
//    public Competition addCompetition(Competition competition) {
//        return competitionDao.save(competition);
//    }

}
