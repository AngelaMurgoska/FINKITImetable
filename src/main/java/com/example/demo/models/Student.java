package com.example.demo.models;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    @Column(columnDefinition = "NVARCHAR(255)")
    private String name;

    @Nationalized
    @Column(columnDefinition = "NVARCHAR(255)")
    private String surname;

    private Long studentindex;

    @Nationalized
    @Column(columnDefinition = "NVARCHAR(255)")
    private String module;

    private String email;

    private Long currentSemester; //koj semestar mu e po red na studentot

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getStudentindex() {
        return studentindex;
    }

    public void setStudentindex(Long studentindex) {
        this.studentindex = studentindex;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(Long currentSemester) {
        this.currentSemester = currentSemester;
    }
}

