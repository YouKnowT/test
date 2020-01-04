package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Data
@Table(name = "Competition")
public class Competition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", student_name='" + student_name + '\'' +
                ", student_guide='" + student_guide + '\'' +
                ", student_class='" + student_class + '\'' +
                ", student_count=" + student_count +
                ", competition_name='" + competition_name + '\'' +
                ", category='" + category + '\'' +
                ", item='" + item + '\'' +
                ", coefficient=" + coefficient +
                ", cardinal=" + cardinal +
                '}';
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "student_name")
    private String student_name;
    @Column(name = "student_guide")
    private String student_guide;
    @Column(name = "student_class")
    private String student_class;
//    @OneToMany
    @Column(name = "student_count")
    private long student_count;
    @Column(name = "competition_name") //名称
    private String competition_name;
    @Column(name = "category") //类别
    private String category;

    @Column(name = "item") //等级
    private String item;

    @Column(name = "coefficient") //系数
    private ArrayList coefficient;

    @Column(name = "cardinal") //
    private ArrayList cardinal;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_guide() {
        return student_guide;
    }

    public void setStudent_guide(String student_guide) {
        this.student_guide = student_guide;
    }

    public String getStudent_class() {
        return student_class;
    }

    public void setStudent_class(String student_class) {
        this.student_class = student_class;
    }

    public long getStudent_count() {
        return student_count;
    }

    public void setStudent_count(long student_count) {
        this.student_count = student_count;
    }

    public String getCompetition_name() {
        return competition_name;
    }

    public void setCompetition_name(String competition_name) {
        this.competition_name = competition_name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public ArrayList getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(ArrayList coefficient) {
        this.coefficient = coefficient;
    }

    public ArrayList getCardinal() {
        return cardinal;
    }

    public void setCardinal(ArrayList cardinal) {
        this.cardinal = cardinal;
    }





}
