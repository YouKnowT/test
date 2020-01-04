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
    public long getUser_count() {
        return user_count;
    }
    public void setUser_count(long user_count) {
        this.user_count = user_count;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", user_count=" + user_count +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;
}