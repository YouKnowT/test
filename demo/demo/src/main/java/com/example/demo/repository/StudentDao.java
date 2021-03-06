package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student,Long> {
    @Query(value = "SELECT s FROM Student s WHERE s.id=?1")
    Student findById(long id);
    @Query(value = "SELECT s FROM Student s WHERE s.user_count=?1")
    Student findByUser_count(long user_count);
    @Query(value = "SELECT s FROM Student s WHERE s.name=?1")
    Student findByName(String name);
    @Query(value = "UPDATE Student s SET s.user_count=?1,s.name=?2,s.id=?3,s.password=?4,s.imgLocal1=?5,s.imgLocal2=?6,s.imgLocal3=?7" )
    void updateStudent(Student student);
    @Query(value = "DELETE FROM Student s WHERE s.user_count=?1")
    void deleteByUser_count(long user_count);
}
