package com.example.demo.service;

import com.example.demo.models.StudentSubjects;

import java.util.List;

public interface StudentSubjectsService {

    List<StudentSubjects> getByStudentId(Long stuId);

    List<StudentSubjects> getByStudentIdAndSemesterId(Long stuId, Long semId);

}
