package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

//import org.springframework.data.annotation.Id;


@Entity
@Table(name = "student")
@Data
public class Student implements Serializable
{
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", user_count=" + user_count +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    public long getUser_count() {
        return user_count;
    }

    public void setUser_count(long user_count) {
        this.user_count = user_count;
    }

    @Column(name = "user_count")
    private long user_count;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "img")
    private String img;
}
