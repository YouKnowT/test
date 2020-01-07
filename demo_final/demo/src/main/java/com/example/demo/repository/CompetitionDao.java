package com.example.demo.repository;

import com.example.demo.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetitionDao extends JpaRepository<Competition,Long> {
    @Query(value = "SELECT c FROM Competition c WHERE c.id=?1")
    Competition findById(long id);
//
//    @Query(value = "SELECT c FROM Competition c WHERE c.category=?1")
//    List<Competition> findByCategory(String category);
//
//    @Query(value = "SELECT c FROM Competition c WHERE c.item=?1")
//    List<Competition> findByItem(String item);
//
//    @Query(value = "SELECT c FROM Competition c WHERE c.student_name=?1")
//    List<Competition> findByName(String name);
//
//    @Query(value = "SELECT * from Competition c where c.student_count=?1",nativeQuery = true)
//    List<Competition> findByNum(long num);
//
//    void deleteById(long id);
//
//    @Query(value = "UPDATE Competition c SET c.item=?1,c.category=?2,c.coefficient=?3,c.cardinal=?4,c.competition_name=?5,c.student_class=?6,c.student_guide=?7,c.student_name=?8")
//    void updateCompetition(Competition competition);

}
