package com.example.demo.service.impl;

import com.example.demo.models.Timetable;
import com.example.demo.repository.JpaTimetableRepository;
import com.example.demo.service.TimetableService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Service
public class TimetableServiceImpl implements TimetableService {

    private JpaTimetableRepository repo;

    public TimetableServiceImpl(JpaTimetableRepository repo){
        this.repo=repo;
    }

    @Override
    public List<Timetable> getByProfessorId(Long profId) {
        return repo.findByProfessorId(profId);
    }

    @Override
    public List<Timetable> getBySubjectId(Long subjId) {
        return repo.findBySubjectId(subjId);
    }

    @Override
    public List<String> getAllRooms() {
        return repo.getAllRooms();
    }

    @Override
    public Optional<Long> getLatestTimetableVersionInSemester(Long semId) {
        return repo.findLatestTimetableVersionInSemester(semId);
    }

    @Override
    public Timetable getByProfessorIdAndSubjectIdAndSemesterIdAndStudentgroupAndVersion(Long profId, Long subjId, Long semId, String studentgroup, Long version) {
        return repo.findByProfessorIdAndSubjectIdAndSemesterIdAndStudentgroupAndVersion(profId, subjId, semId, studentgroup, version);
    }

    @Override
    public List<Timetable> getBySubjectIdAndSemesterIdAndStudentgroupAndVersion(Long subjId, Long sessId,String studentgroup,Long version) {
        return repo.findBySubjectIdAndSemesterIdAndStudentgroupAndVersion(subjId,sessId,studentgroup,version);
    }

    @Override
    public Collection<Timetable> saveAll(Collection<Timetable> exams) {
        return repo.saveAll(exams);
    }

    @Override
    public List<Timetable> getByProfessorIdAndSemesterIdAndRoomAndVersion(Long profId, Long semId, String room, Long version) {
        return repo.findByProfessorIdAndSemesterIdAndRoomAndVersion(profId, semId, room,version);
    }

    @Override
    public List<Timetable> getByProfessorIdAndSemesterIdAndVersion(Long profId, Long semId,Long version) {
        return repo.findByProfessorIdAndSemesterIdAndVersion(profId,semId,version);
    }

    @Override
    public List<Timetable> getBySemesterIdAndRoomAndVersion(Long semId, String room, Long version) {
        return repo.findBySemesterIdAndRoomAndVersion(semId, room,version);
    }


}
