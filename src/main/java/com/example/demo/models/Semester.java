package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name="semester")
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long semesterType; // 0=leten semestar, 1=zimski semestar

    private String academicYear;

    private Long overallSemesterNo;

    public Semester(){}

    public Semester(Long semesterType, String academicYear){
        this.semesterType=semesterType;
        this.academicYear=academicYear;
    }

    public Long getId() {
        return id;
    }

    public Long getSemesterType() {
        return semesterType;
    }

    public void setSemesterType(Long semesterType) {
        this.semesterType = semesterType;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Long getOverallSemesterNo() {
        return overallSemesterNo;
    }

    public void setOverallSemesterNo(Long overallSemesterNo) {
        this.overallSemesterNo = overallSemesterNo;
    }
}
