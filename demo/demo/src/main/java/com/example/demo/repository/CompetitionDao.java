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
    @Query(value = "SELECT c FROM Competition c WHERE c.categorys=?1")
    List<Competition> findByCategory(String categorys);
    @Query(value = "SELECT c FROM Competition c WHERE c.item=?1")
    List<Competition> findByItem(String item);
    @Query(value = "DELETE FROM Competition c WHERE c.suser_count=?1 AND c.categorys=?2 AND c.item=?3")
    void deleteCompetitionByCategorysAndItemAndSuser_count(long suser_count,String category,String item);
    @Query(value = "UPDATE Competition c SET c.suser_count=?1,c.id=?2,c.item=?3,c.cardinal=?4,c.coefficient=?5,c.tuser_count=?6,c.categorys=?7")
    void updateCompetition(Competition competition);
    @Query(value = "SELECT c FROM Competition c WHERE c.suser_count=?1 AND c.categorys=?2 AND c.item=?3")
    Competition findBySuser_countAndCategorysAndItem(long suser_count,String categorys,String item);
    List<Competition> findAll();
}
