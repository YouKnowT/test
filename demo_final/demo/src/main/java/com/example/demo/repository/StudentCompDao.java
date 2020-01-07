package com.example.demo.repository;

import com.example.demo.entity.StudentComp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCompDao extends JpaRepository<StudentComp, Long> {

    @Query("select st from StudentComp st where st.comId = ?1")
    List<StudentComp> findByComId(Long id);

    @Query("select st from StudentComp st where st.studentId = ?1")
    List<StudentComp> findByStudentId(Long id);

}
