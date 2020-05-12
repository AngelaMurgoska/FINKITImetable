package com.example.demo.service.impl;

import com.example.demo.models.Semester;
import com.example.demo.models.Student;
import com.example.demo.models.StudentSubjects;
import com.example.demo.models.Timetable;
import com.example.demo.models.nonEntity.StudentTimetable;
import com.example.demo.service.StudentTimetableService;
import com.example.demo.service.TimetableService;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentTimetableServiceImpl implements StudentTimetableService {

    private TimetableService timetableService;

    public StudentTimetableServiceImpl(TimetableService timetableService){
        this.timetableService=timetableService;
    }

    //raboti nezavisno od semestar, dava latest verzija na raspored za student od bilo koj semestar
    @Override
    public List<StudentTimetable> getStudentTimetableLatestVersion(Student student, Semester semester, List<StudentSubjects> studentSubjects) {
        List<StudentTimetable> studentTimetableList = new ArrayList<>();;
        Long lastTimetableVersion=timetableService.getLatestTimetableVersionInSemester(semester.getId()).get();

        for (StudentSubjects s : studentSubjects) {

            List<Timetable> timetables=timetableService.getBySubjectIdAndSemesterIdAndStudentgroupAndVersion(s.getSubject().getId(),semester.getId(),s.getStudentGroupTimetable(),lastTimetableVersion);
            for(Timetable timetable : timetables) {
                if(s.getProfessor().getId().compareTo(timetable.getProfessor().getId())!=0 && !timetable.getProfessor().getName().contains("м-р"))
                    continue;
                String hourFrom;
                if (timetable.getHourFrom() == 8 || timetable.getHourFrom() == 9) {
                    hourFrom = "0" + timetable.getHourFrom() + ":00";
                } else hourFrom = timetable.getHourFrom() + ":00";
                StudentTimetable studentTimetable = new StudentTimetable(student.getName(), student.getSurname(),
                        student.getStudentindex(), student.getModule(), s.getSubject().getName(), timetable.getProfessor().getName(),
                        s.getStudentGroupTimetable(), timetable.getRoom(), hourFrom, timetable.getHourTo() + ":00", timetable.getDay());
                studentTimetableList.add(studentTimetable);
            }
        }

        return studentTimetableList;
    }
}
