package com.example.demo.repository;

import com.example.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao extends JpaRepository<Teacher,Long> {

    @Query(value = "SELECT t FROM Teacher t WHERE t.id=?1")
    Teacher findById(long id) ;
    @Query(value = "SELECT t FROM Teacher t WHERE t.userAccount=?1")
    Teacher findByUserAccount(long userAccount) ;

    @Query(value = "SELECT t from Teacher t where t.audit=?1")
    List<Teacher> findAllByAudit(Boolean audit);
//    @Query(value = "SELECT t FROM Teacher t WHERE t.name=?1")
//    Teacher findByName(String name) ;
//    @Query(value = "update Teacher t set t.audit=?1 where t.id=?2")
//    int updateTeacherAudit(Boolean audit, Long id);
//    @Query(value = "UPDATE Teacher t SET t.userAccount= ?1,t.name= ?2,t.password= ?3")
//    void updateTeacher(Teacher teacher);
//    @Query(value = "DELETE FROM Teacher t WHERE t.user_count=?1")
//    void deleteByUser_count(long user_count);
}
