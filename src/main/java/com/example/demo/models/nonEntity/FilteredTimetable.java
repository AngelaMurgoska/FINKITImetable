package com.example.demo.models.nonEntity;

public class FilteredTimetable {

    private String subjectName;
    private String professorName;
    private String group;

    private String room;
    private String startTime;
    private String endTime;
    private Long day;

    public FilteredTimetable(String subjectName, String professorName, String group, String room, String startTime, String endTime, Long day) {
        this.subjectName = subjectName;
        this.professorName = professorName;
        this.group = group;
        this.room = room;
        this.startTime = startTime;
        this.endTime = endTime;
        this.day = day;
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
