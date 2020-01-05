package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "user_count")
    private long user_count;

    @Column(name = "is_audit")
    private Boolean isAudit;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", user_count=" + user_count +
                ", isAudit=" + isAudit +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_count() {
        return user_count;
    }

    public void setUser_count(long user_count) {
        this.user_count = user_count;
    }

    public Boolean getAudit() {
        return isAudit;
    }

    public void setAudit(Boolean audit) {
        isAudit = audit;
    }
}