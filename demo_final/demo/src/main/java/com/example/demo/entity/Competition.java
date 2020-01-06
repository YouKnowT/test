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
    @JoinColumn(name = "teacher_id")
    private long teacherId;

    @JoinColumn(name = "teacher_name")
    private String teacherName;

    // 参赛学生
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "stu_compet", joinColumns = @JoinColumn(name = "com_id"),
            inverseJoinColumns = @JoinColumn(name = "stu_id"))
    private Set<Student> students;

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
                ", students=" + students +
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
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
}
