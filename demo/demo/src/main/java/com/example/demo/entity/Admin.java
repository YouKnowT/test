package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@Data
public class Admin {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;



}