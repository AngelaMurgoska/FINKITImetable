package com.example.demo.models;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nationalized
    @Column(columnDefinition = "NVARCHAR(255)")
    private String name;
    private Long semesterNo;  //vo koj semestar po pravilo treba da se slusa predmetot (1,2,3,....)

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSemesterNo() {
        return semesterNo;
    }

    public void setSemesterNo(Long semesterNo) {
        this.semesterNo = semesterNo;
    }
}

