package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "user_account")
    private long userAccount;

    @Column(name = "password")
    private String password;

    @Column(name = "is_audit")
    private Boolean audit;

    @Column(name = "name")
    private String name;

    @Column(name = "img")
    private String img;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stu_compet", joinColumns = @JoinColumn(name = "stu_id"),
            inverseJoinColumns = @JoinColumn(name = "com_id"))
    private Set<Competition> competitions;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userAccount=" + userAccount +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", img='" + img + '\'' +
                ", competitions=" + competitions +
                "is_audit"+audit+
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserCount() {
        return userAccount;
    }

    public void setUserCount(long userAccount) {
        this.userAccount = userAccount;
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

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }

    public Boolean getAudit() {
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }
}
