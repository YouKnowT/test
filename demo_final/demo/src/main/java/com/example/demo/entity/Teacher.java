package com.example.demo.entity;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "user_account")
    private long userAccount;

    @Column(name = "password")
    private String password;

    @Column(name = "is_audit")
    private Boolean isAudit;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "com_id")
    private Set<Competition> competitions;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", userAccount=" + userAccount +
                ", password='" + password + '\'' +
                ", isAudit=" + isAudit +
                ", name='" + name + '\'' +
                ", competitions=" + competitions +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(long userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAudit() {
        return isAudit;
    }

    public void setAudit(Boolean audit) {
        isAudit = audit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }
}