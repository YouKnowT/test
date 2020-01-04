package com.example.demo.repository;

import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends JpaRepository<Teacher,Long> {
    @Query(value = "SELECT t FROM Teacher t WHERE t.id=?1")
    Teacher findById(long id) ;
    @Query(value = "SELECT t FROM Teacher t WHERE t.user_count=?1")
    Teacher findByUser_count(long user_count) ;
    @Query(value = "SELECT t FROM Teacher t WHERE t.name=?1")
    Teacher findByName(String name) ;
    @Query(value = "UPDATE Teacher t SET t.user_count=?1,t.name=?2,t.password=?3")
    void updateTeacher(Teacher teacher);
    @Query(value = "DELETE FROM Teacher t WHERE t.user_count=?1")
    void deleteByUser_count(long user_count);
}
