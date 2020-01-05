package com.example.demo.service.implement;


import com.example.demo.entity.Competition;
import com.example.demo.repository.CompetitionDao;
import com.example.demo.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("competitionService")
public class CompetitionServiceImp implements CompetitionService {
//    @Autowired
//    CompetitionDao competitionDao;
//
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
//    @Override
//    public List<Competition> findAll() {
//        return competitionDao.findAll();
//    }
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
