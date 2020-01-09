package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "competition")
public class Competition implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    //竞赛名称
    @Column(name = "name")
    private String name;

    // 指导教师
    @Column(name = "teacher_id")
    private long teacherId;

    @Column(name = "teacher_name")
    private String teacherName;

    // 竞赛类别
    @Column(name = "category")
    private String category;

    // 竞赛等级
    @Column(name = "level")
    private String level;

    // 竞赛证书
    @Column(name = "certificate")
    private String certificate;

    // 指导证书
    @Column(name = "guidance_certificate")
    private String guidaceCertificate;

    @Column(name = "student_name")
    private String student_name;

    @Column(name = "student_count")
    private long student_count;

    // 比赛照片
    @Column(name = "imgs")
    private String imgs;

    // 开始时间
    @Column(name = "start_time")
    private Date startTime;

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherName=" + teacherName +
                ", teacherId=" + teacherId +
                ", category='" + category + '\'' +
                ", level='" + level + '\'' +
                ", certificate='" + certificate + '\'' +
                ", guidaceCertificate='" + guidaceCertificate + '\'' +
                ", imgs=" + imgs +
                ", startTime" + startTime +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getGuidaceCertificate() {
        return guidaceCertificate;
    }

    public void setGuidaceCertificate(String guidaceCertificate) {
        this.guidaceCertificate = guidaceCertificate;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public long getStudent_count() {
        return student_count;
    }

    public void setStudent_count(long student_count) {
        this.student_count = student_count;
    }

//    public double getGzl() {
//        return gzl;
//    }
//
//    public void setGzl(double gzl) {
//        this.gzl = gzl;
//    }
}
