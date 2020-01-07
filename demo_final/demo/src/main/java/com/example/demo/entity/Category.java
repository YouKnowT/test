package com.example.demo.entity;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    // 类别名
    @Column(name = "name")
    private String name;

    //工作量
    @Column(name = "gzl")
    private double gzl;

    //基数
    @Column(name = "base")
    private Float base;

    // 系数
    @Column(name = "cardinal_number")
    private Float cardinalNumber;

    // 类别对应的项目
    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Set<Project> projects = new HashSet<>();

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardinalNumber=" + cardinalNumber +
                ", projects=" + projects +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCardinalNumber() {
        return cardinalNumber;
    }

    public void setCardinalNumber(Float cardinalNumber) {
        this.cardinalNumber = cardinalNumber;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Float getBase() {
        return base;
    }

    public void setBase(Float base) {
        this.base = base;
    }

    public double getGzl() {
        return gzl;
    }

    public void setGzl(double gzl) {
        this.gzl = gzl;
    }
}
