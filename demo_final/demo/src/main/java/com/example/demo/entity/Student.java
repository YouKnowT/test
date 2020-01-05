package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "user_count")
    private long userCount;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "img")
    private String img;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userCount=" + userCount +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserCount() {
        return userCount;
    }

    public void setUserCount(long userCount) {
        this.userCount = userCount;
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
}
