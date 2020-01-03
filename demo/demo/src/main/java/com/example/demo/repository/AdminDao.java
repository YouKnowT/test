package com.example.demo.repository;

import com.example.demo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminDao extends JpaRepository<Admin,Long> {
    @Query(value = "SELECT a FROM Admin a where a.id=?1")
    Admin findById(long id);
    @Query(value = "SELECT a FROM Admin a where a.name=?1")
    Admin findByName(String name);

}