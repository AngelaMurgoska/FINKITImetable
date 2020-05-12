package com.example.demo.models;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Table(name="timetable")
public class Timetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hourFrom;
    private Long hourTo;
    private Long day;

    @Nationalized
    @Column(columnDefinition = "NVARCHAR(255)")
    private String room;

    @Nationalized
    @Column(columnDefinition = "NVARCHAR(255)")
    private String studentgroup;

    private Long version;

    @ManyToOne
    @JoinColumn(name = "professor_id", updatable = false)
    private Professor professor;

    @ManyToOne
    @JoinColumn(name = "subject_id", updatable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "semester_id", updatable = false)
    private Semester semester;

    public Timetable(Long hourFrom, Long hourTo, Long day, String room, String studentgroup, Professor professor, Subject subject, Semester semester, Long version) {
    this.hourFrom=hourFrom;
    this.hourTo=hourTo;
    this.day=day;
    this.room=room;
    this.studentgroup=studentgroup;
    this.professor=professor;
    this.subject=subject;
    this.semester=semester;
    this.version=version;
    }

    public Timetable(){}


    public Long getId() {
        return id;
    }

    public Long getHourFrom() {
        return hourFrom;
    }

    public void setHourFrom(Long hourFrom) {
        this.hourFrom = hourFrom;
    }

    public Long getHourTo() {
        return hourTo;
    }

    public void setHourTo(Long hourTo) {
        this.hourTo = hourTo;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getStudentgroup() {
        return studentgroup;
    }

    public void setStudentgroup(String studentgroup) {
        this.studentgroup = studentgroup;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
