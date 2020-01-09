package com.example.demo.service;

import com.example.demo.entity.Competition;

import java.util.List;
import java.util.Optional;

public interface CompetitionService {
    Competition findById(long id);
//    List<Competition> findByCategory(String category);
//    List<Competition> findByItem(String item);
////    List<Competition> findByName(String name);
//    List<Competition> findByNum(long num);
    List<Competition> findAll();
    Competition save(Competition competition);
    Competition saveCompetition(Competition competition);
//    void updateCompetition(Competition competition);
    void deleteById(long id);


    void updateCompetition(Competition competition);

    //List<Competition> findByName(long name);

    List<Competition> findByStudent_name(String name);

    List<Competition> findByStudent_count(long user_account);
//    Competition addCompetition(Competition competition);
}
