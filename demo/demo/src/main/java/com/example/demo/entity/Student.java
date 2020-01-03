package com.example.demo.entity;

import lombok.Data;
//import org.springframework.data.annotation.Id;
import javax.persistence.*;


@Entity
@Table(name = "student")
@Data
public class Student {
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

    @Column(name = "imgLocal1")
    private String imgLocal1;

    @Column(name = "imgLocal2")
    private String imgLocal2;

    @Column(name = "imgLocal3")
    private String imgLocal3;
}
