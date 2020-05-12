package com.example.demo.models.nonEntity;


public class StudentTimetable {

    private String name;
    private String surname;
    private Long studentindex;
    private String module;

    private String subjectName;
    private String professorName;
    private String group;

    private String room;
    private String startTime;
    private String endTime;
    private Long day;

    public StudentTimetable(String name, String surname, Long studentindex, String module, String subjectName, String professorName, String group, String room, String hourFrom, String hourTo, Long day) {
        this.name = name;
        this.surname = surname;
        this.studentindex = studentindex;
        this.module = module;
        this.subjectName = subjectName;
        this.professorName = professorName;
        this.group = group;
        this.room = room;
        this.startTime = hourFrom;
        this.endTime = hourTo;
        this.day=day;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Long getStudentindex() {
        return studentindex;
    }

    public String getModule() {
        return module;
    }


    public String getSubjectName() {
        return subjectName;
    }


    public String getProfessorName() {
        return professorName;
    }


    public String getGroup() {
        return group;
    }

    public String getRoom() {
        return room;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Long getDay() {
        return day;
    }
}
