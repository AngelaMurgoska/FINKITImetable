package com.example.demo.service;


import com.example.demo.models.Timetable;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

public interface TimetableService {

    List<Timetable> getByProfessorId(Long profId);

    List<Timetable> getBySubjectId(Long subjId);

    List<String> getAllRooms();

    Optional<Long> getLatestTimetableVersionInSemester(Long semId);

    Timetable getByProfessorIdAndSubjectIdAndSemesterIdAndStudentgroupAndVersion(Long profId,Long subjId,Long semId,String studentgroup,Long version);

    List<Timetable> getBySubjectIdAndSemesterIdAndStudentgroupAndVersion(Long subjId, Long semId, String studentgroup, Long version);

    Collection<Timetable> saveAll(Collection<Timetable> exams);

    List<Timetable> getByProfessorIdAndSemesterIdAndRoomAndVersion(Long profId, Long semId, String room,Long version);

    List<Timetable> getByProfessorIdAndSemesterIdAndVersion(Long profId, Long semId, Long version);

    List<Timetable> getBySemesterIdAndRoomAndVersion(Long semId,String room,Long version);

}
