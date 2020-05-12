package com.example.demo.service.impl;

import com.example.demo.models.Professor;
import com.example.demo.models.Semester;
import com.example.demo.models.Subject;
import com.example.demo.models.Timetable;
import com.example.demo.models.nonEntity.TimetableUpload;
import com.example.demo.service.TimetableUploadService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TimetableUploadServiceImpl implements TimetableUploadService {

    private ProfessorServiceImpl professorService;
    private SubjectServiceImpl subjectService;
    private SemesterServiceImpl semesterService;
    private TimetableServiceImpl timetableService;

    public TimetableUploadServiceImpl(ProfessorServiceImpl professorService, SubjectServiceImpl subjectService, SemesterServiceImpl semesterService, TimetableServiceImpl timetableService) {
        this.professorService = professorService;
        this.subjectService = subjectService;
        this.semesterService = semesterService;
        this.timetableService=timetableService;
    }

    //dodavanje na nova verzija na raspored vo posledno dodadeniot semestar
    @Override
    public void saveDataFromCsvFile(List<TimetableUpload> inputData) {

        Map<String, Timetable> timetables=new HashMap<>();

        Semester semester=semesterService.getLatestSemester();

        Optional<Long> latestVersionInSemester=timetableService.getLatestTimetableVersionInSemester(semester.getId());

        long version;
        if(latestVersionInSemester.isPresent())  version=latestVersionInSemester.get();
        else version=0;

        //timetableUpload = eden red od csv fajlot
        for (TimetableUpload timetableUpload : inputData) {

            //odreduvanje na modul
            String [] studentgroup=timetableUpload.getModule().split("-");
            String module=studentgroup[0].trim();
            long semesterNo=Long.parseLong(studentgroup[1].trim())*2-1;
            if(!Character.isUpperCase(module.charAt(1))){
                studentgroup=module.split(" ");
                module=studentgroup[1];
            }

            String identifier=timetableUpload.getProfessor()+" "+timetableUpload.getSubject()+" "+timetableUpload.getRoom()+" "+module;

            if(!timetables.containsKey(identifier)){

                //vnesuvanje na profesori i asistenti
                Professor professor=professorService.getProfessorByName(timetableUpload.getProfessor());

                Subject subject=subjectService.getByNameAndSemesterNo(timetableUpload.getSubject(),semesterNo);

                Timetable newTimetable=new Timetable(8+Long.parseLong(timetableUpload.getHourFrom()),
                        9+Long.parseLong(timetableUpload.getHourFrom()),Long.parseLong(timetableUpload.getDay()), timetableUpload.getRoom(),
                        module,professor,subject,semester,version+1);
                timetables.put(identifier,newTimetable);
            }
            else{
                Timetable existingTimetable=timetables.get(identifier);
                existingTimetable.setHourTo(existingTimetable.getHourTo()+1);
                timetables.replace(identifier,existingTimetable);
            }
             timetableService.saveAll(timetables.values());
        }
    }
}
