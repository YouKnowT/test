package com.example.demo.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import java.util.Date;
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
    private Boolean audit;

    @Column(name = "name")
    private String name;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "com_id")
    private Set<Competition> competitions;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", userAccount=" + userAccount +
                ", password='" + password + '\'' +
                ", audit=" + audit +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
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
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
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

}