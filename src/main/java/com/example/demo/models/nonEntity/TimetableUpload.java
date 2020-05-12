package com.example.demo.models.nonEntity;

import com.opencsv.bean.CsvBindByName;

public class TimetableUpload {

    @CsvBindByName
    private long id;
    @CsvBindByName
    private String module;
    @CsvBindByName
    private String professor;
    @CsvBindByName
    private String subject;
    @CsvBindByName
    private String room;
    @CsvBindByName
    private String day;
    @CsvBindByName
    private String hourFrom;
    @CsvBindByName
    private String hourTo;
    @CsvBindByName
    private String space;

    public TimetableUpload(){}

    public TimetableUpload(long id, String module, String professor, String subject, String room, String day, String hourFrom, String hourTo, String space) {
        this.id = id;
        this.module = module;
        this.professor = professor;
        this.subject = subject;
        this.room = room;
        this.day = day;
        this.hourFrom = hourFrom;
        this.hourTo = hourTo;
        this.space = space;
    }

    public long getId() {
        return id;
    }

    public String getModule() {
        return module;
    }

    public String getProfessor() {
        return professor;
    }

    public String getSubject() {
        return subject;
    }

    public String getRoom() {
        return room;
    }

    public String getDay() {
        return day;
    }

    public String getHourFrom() {
        return hourFrom;
    }

    public String getHourTo() {
        return hourTo;
    }

    public String getSpace() {
        return space;
    }
}
