package com.example.demo.service;

import com.example.demo.models.Semester;

import java.util.List;
import java.util.Optional;

public interface SemesterService {

    List<Semester> getAllSemesters();

    Optional<Semester> findById(Long id);

    Semester save(Semester s);

    Semester getLatestSemester();

    Long getMaxOverallSemesterNo();
}
