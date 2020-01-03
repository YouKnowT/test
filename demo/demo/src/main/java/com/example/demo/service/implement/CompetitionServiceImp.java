package com.example.demo.service.implement;


import com.example.demo.entity.Competition;
import com.example.demo.repository.CompetitionDao;
import com.example.demo.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("competitionService")
public class CompetitionServiceImp implements CompetitionService {
    @Autowired
    CompetitionDao competitionDao;

    @Override
    public Competition findById(long id){
        return competitionDao.findById(id);
    }
    @Override
    public List<Competition> findByCategory(String categorys){
        return competitionDao.findByCategory(categorys);
    }
    @Override
    public List<Competition> findByItem(String item){
        return competitionDao.findByItem(item);
    }

    public void deleteCompetitionByCategorysAndItemAndSuser_count(long suser_count, String categorys, String item){
        competitionDao.deleteCompetitionByCategorysAndItemAndSuser_count(suser_count,categorys,item);
    }

    @Override
    public List<Competition> findAll() {
        return competitionDao.findAll();
    }

    @Override
    public void updateCompetition(Competition competition) {
        competitionDao.updateCompetition(competition);
    }

    @Override
    public Competition addCompetiton(Competition competition) {
        return competitionDao.save(competition);
    }

    @Override
    public Competition findBySuser_countAndCategorysAndItem(long suser_count, String category, String item) {
        return competitionDao.findBySuser_countAndCategorysAndItem(suser_count,category,item);
    }


}
