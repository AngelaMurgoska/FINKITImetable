package com.example.demo.rest;

import com.example.demo.models.Professor;
import com.example.demo.models.Semester;
import com.example.demo.models.Student;
import com.example.demo.models.StudentSubjects;
import com.example.demo.models.exceptions.EmptyFileException;
import com.example.demo.models.exceptions.MissingParametersException;
import com.example.demo.models.nonEntity.TimetableUpload;
import com.example.demo.models.nonEntity.FilteredTimetable;
import com.example.demo.models.nonEntity.StudentTimetable;
import com.example.demo.service.impl.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/timetable/")
@CrossOrigin(origins = "http://localhost:3000")
public class TimetableRestController {

    private TimetableServiceImpl timetableService;
    private ProfessorServiceImpl professorService;
    private SemesterServiceImpl semesterService;
    private StudentServiceImpl studentService;
    private StudentSubjectsServiceImpl studentSubjectsService;
    private StudentTimetableServiceImpl studentTimetableService;
    private FilteredTimetableServiceImpl filteredTimetableService;
    private TimetableUploadServiceImpl timetableUploadService;

    public TimetableRestController(TimetableServiceImpl timetableService, ProfessorServiceImpl professorService, SemesterServiceImpl semesterService, StudentServiceImpl studentService, StudentSubjectsServiceImpl studentSubjectsService, StudentTimetableServiceImpl studentTimetableService,FilteredTimetableServiceImpl filteredTimetableService, TimetableUploadServiceImpl timetableUploadService) {
        this.timetableService = timetableService;
        this.professorService = professorService;
        this.semesterService = semesterService;
        this.studentService = studentService;
        this.studentSubjectsService = studentSubjectsService;
        this.studentTimetableService=studentTimetableService;
        this.filteredTimetableService=filteredTimetableService;
        this.timetableUploadService=timetableUploadService;
    }

    @GetMapping("/professors")
    public List<Professor> getAllProfessors(){
        return professorService.getAllProfessors();
    }

    @GetMapping("/rooms")
    public List<String> getAllRooms(){
        return timetableService.getAllRooms();
    }

    @GetMapping("{index}")
    public Student getStudentInfo(@PathVariable("index") String studentindex) {
        return studentService.getByStuIndex(Long.parseLong(studentindex));
    }

    @GetMapping("studentemail/{email}")
    public Student getStudentAuthenticationInfo(@PathVariable("email") String email) {
        return studentService.getByStuEmail(email);
    }

    /*the timetable for a student that appears after the student logs in*/
    @GetMapping("student/{index}/{day}")
    public List<StudentTimetable> getCurrentStudentTimetable(@PathVariable("index") String studentindex, @PathVariable("day") Long day) {
        Student student = studentService.getByStuIndex(Long.parseLong(studentindex));
        Semester latestSemester=semesterService.getLatestSemester();
        List<StudentSubjects> studentSubjects = studentSubjectsService.getByStudentIdAndSemesterId(student.getId(),latestSemester.getId());
        List<StudentTimetable> studentTimetable=studentTimetableService.getStudentTimetableLatestVersion(student,latestSemester,studentSubjects);
        return studentTimetable.stream().filter(m -> m.getDay().equals(day)).collect(Collectors.toList());
    }

    /*timetable filtered by professor, room or both; no need to log in*/
    @GetMapping("filter/{day}")
    public List<FilteredTimetable> getFilteredTimetable(@PathVariable("day") Long day, @RequestParam(required = false) String professorId, @RequestParam(required = false) String room){

        if(professorId==null && room==null) throw new MissingParametersException();

        Semester latestSemester=semesterService.getLatestSemester();
        List<FilteredTimetable> filteredTimetableList = new ArrayList<>();

        if(professorId!=null && room!=null){
            filteredTimetableList=filteredTimetableService.getFilteredTimetableByProfessorAndRoomLatestVersion(latestSemester,Long.parseLong(professorId),room);
        }
        else if(professorId!=null){
            filteredTimetableList=filteredTimetableService.getFilteredTimetableByProfessorLatestVersion(latestSemester,Long.parseLong(professorId));
        }
        else{
            filteredTimetableList=filteredTimetableService.getFilteredTimetableByRoomLatestVersion(latestSemester,room);
        }
       return filteredTimetableList.stream().filter(m -> m.getDay().equals(day)).collect(Collectors.toList());
    }

    /*upload na nov raspored*/
    @PostMapping("upload-timetable")
    public void uploadCSVFile(@RequestParam("file") MultipartFile file,@RequestParam(required = false) String semesterType,@RequestParam(required = false) String academicYear) {

        if (file.isEmpty()) {
            throw new EmptyFileException();
        } else {
            // parse CSV file to create a list of `TimetableUpload` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                // create csv bean reader
                CsvToBean<TimetableUpload> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(TimetableUpload.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                List<TimetableUpload> inputData = csvToBean.parse();

                //ako se dodava nova sesija, tuka se kreira
                if(semesterType!=null && academicYear!=null){
                    Semester newSemester=new Semester(Long.parseLong(semesterType),academicYear);
                    semesterService.save(newSemester);
                    Long currentLatestSemester=semesterService.getMaxOverallSemesterNo();
                    newSemester.setOverallSemesterNo(currentLatestSemester+1);
                }

                timetableUploadService.saveDataFromCsvFile(inputData);

        } catch (Exception ex) {
                System.err.println("Something went wrong while parsing the csv file");
            }
        }
    }

}
