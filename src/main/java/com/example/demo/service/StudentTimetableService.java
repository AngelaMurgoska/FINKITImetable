package com.example.demo.service;

import com.example.demo.models.Semester;
import com.example.demo.models.Student;
import com.example.demo.models.StudentSubjects;
import com.example.demo.models.nonEntity.StudentTimetable;

import java.util.List;

public interface StudentTimetableService {

    List<StudentTimetable> getStudentTimetableLatestVersion(Student student, Semester semester, List<StudentSubjects> studentSubjects);

}
