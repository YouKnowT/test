package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Table(name = "Competition")
public class Competition implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    //竞赛名称
    @Column(name = "name")
    private String name;

    // 指导教师
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    // 参赛学生
    @ManyToMany
    @JoinTable(name = "stu_compet", joinColumns = @JoinColumn(name = "com_id"),
            inverseJoinColumns = @JoinColumn(name = "stu_id"))
    private Set<Student> students;





}
