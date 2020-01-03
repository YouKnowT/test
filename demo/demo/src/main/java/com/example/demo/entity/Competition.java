package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "competition")
public class Competition {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "categorys")
    private String categorys;

    @Column(name = "item")
    private String item;

    @Column(name = "coefficient")
    private double coefficient;

    @Column(name = "cardinal")
    private double cardinal;

    @Column(name = "suser_count")
    private long suser_count;

    @Column(name = "tuser_count")
    private long tuser_count;

    @Column(name = "sname")
    private String sname;

    @Column(name = "gzl")
    private double gzl;
}
