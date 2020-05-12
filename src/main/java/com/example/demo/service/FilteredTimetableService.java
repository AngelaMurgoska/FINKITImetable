package com.example.demo.service;

import com.example.demo.models.Semester;
import com.example.demo.models.nonEntity.FilteredTimetable;

import java.util.List;

public interface FilteredTimetableService {

    List<FilteredTimetable> getFilteredTimetableByProfessorAndRoomLatestVersion(Semester semester,Long profId, String room);

    List<FilteredTimetable> getFilteredTimetableByProfessorLatestVersion(Semester semester,Long profId);

    List<FilteredTimetable> getFilteredTimetableByRoomLatestVersion(Semester semester, String room);

}
