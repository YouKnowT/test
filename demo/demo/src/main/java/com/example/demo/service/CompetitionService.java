package com.example.demo.service;

import com.example.demo.entity.Competition;

import java.util.List;

public interface CompetitionService {
    Competition findById(long id);
    List<Competition> findByCategory(String categorys);
    List<Competition> findByItem(String item);
    void updateCompetition(Competition competition);
    Competition addCompetiton(Competition competition);

    Competition findBySuser_countAndCategorysAndItem(long suser_count,String categorys,String item);
    void deleteCompetitionByCategorysAndItemAndSuser_count(long suser_count,String categorys,String item);

    List<Competition> findAll();


}
