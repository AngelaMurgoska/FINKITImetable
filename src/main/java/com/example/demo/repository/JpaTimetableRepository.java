package com.example.demo.repository;

import com.example.demo.models.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaTimetableRepository extends JpaRepository<Timetable,Long> {

    List<Timetable> findByProfessorId(Long id);

    List<Timetable> findBySubjectId(Long id);

    @Query("SELECT DISTINCT(t.room) FROM Timetable t")
    List<String> getAllRooms();

    @Query("SELECT MAX(t.version) FROM Timetable t WHERE t.semester.id=:semester_id")
    Optional<Long> findLatestTimetableVersionInSemester(@Param("semester_id") Long semId);

    Timetable findByProfessorIdAndSubjectIdAndSemesterIdAndStudentgroupAndVersion(Long profId,Long subjId, Long semId, String studentgroup, Long version);

    List<Timetable> findBySubjectIdAndSemesterIdAndStudentgroupAndVersion(Long subjId, Long semId, String studentgroup, Long version);

    List<Timetable> findByProfessorIdAndSemesterIdAndRoomAndVersion(Long profId,Long semId, String room, Long version);

    List<Timetable> findByProfessorIdAndSemesterIdAndVersion(Long profId, Long semId, Long version);

    List<Timetable> findBySemesterIdAndRoomAndVersion(Long semId, String room, Long version);

    @Override
    <S extends Timetable> List<S> saveAll(Iterable<S> iterable);
}
