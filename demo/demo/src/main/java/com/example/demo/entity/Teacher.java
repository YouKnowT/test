package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Data
public class Teacher {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "user_count")
    private long user_count;


    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;


}