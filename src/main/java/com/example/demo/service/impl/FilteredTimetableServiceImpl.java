package com.example.demo.service.impl;

import com.example.demo.models.Semester;
import com.example.demo.models.Timetable;
import com.example.demo.models.nonEntity.FilteredTimetable;
import com.example.demo.service.FilteredTimetableService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilteredTimetableServiceImpl implements FilteredTimetableService {

    private TimetableServiceImpl timetableService;

    public FilteredTimetableServiceImpl(TimetableServiceImpl timetableService) {
        this.timetableService = timetableService;
    }

    //raboti nezavisno od semestar, dava latest filtrirana verzija na raspored od bilo koj semestar
    @Override
    public List<FilteredTimetable> getFilteredTimetableByProfessorAndRoomLatestVersion(Semester semester, Long profId, String room) {
        Long lastTimetableVersion=timetableService.getLatestTimetableVersionInSemester(semester.getId()).get();
        List<Timetable> timetableList=timetableService.getByProfessorIdAndSemesterIdAndRoomAndVersion(profId,
                semester.getId(),room,lastTimetableVersion);
        return  getFilteredTimetable(timetableList);
    }

    @Override
    public List<FilteredTimetable> getFilteredTimetableByProfessorLatestVersion(Semester semester, Long profId) {
        Long lastTimetableVersion=timetableService.getLatestTimetableVersionInSemester(semester.getId()).get();
        List<Timetable> timetableList=timetableService.getByProfessorIdAndSemesterIdAndVersion(profId,
                semester.getId(),lastTimetableVersion);
        return getFilteredTimetable(timetableList);
    }

    @Override
    public List<FilteredTimetable> getFilteredTimetableByRoomLatestVersion(Semester semester, String room) {
        Long lastTimetableVersion=timetableService.getLatestTimetableVersionInSemester(semester.getId()).get();
        List<Timetable> timetableList=timetableService.getBySemesterIdAndRoomAndVersion(semester.getId(),room,lastTimetableVersion);
        return getFilteredTimetable(timetableList);
    }

    private List<FilteredTimetable> getFilteredTimetable(List<Timetable> timetableList){
        List<FilteredTimetable> filteredTimetableList = new ArrayList<>();
        for(Timetable t  : timetableList){
            String hourFrom;
            if (t.getHourFrom() == 8 || t.getHourFrom() == 9) {
                hourFrom = "0" + t.getHourFrom() + ":00";
            } else hourFrom = t.getHourFrom() + ":00";


            FilteredTimetable filteredTimetable = new FilteredTimetable(t.getSubject().getName(), t.getProfessor().getName(),
                    t.getStudentgroup(), t.getRoom(), hourFrom, t.getHourTo() + ":00", t.getDay());
            filteredTimetableList.add(filteredTimetable);
        }
        return filteredTimetableList;
    }
}
