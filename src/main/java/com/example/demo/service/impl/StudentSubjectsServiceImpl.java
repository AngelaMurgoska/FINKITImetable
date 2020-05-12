package com.example.demo.service.impl;

import com.example.demo.models.StudentSubjects;
import com.example.demo.repository.JpaStudentSubjectsRepository;
import com.example.demo.service.StudentSubjectsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSubjectsServiceImpl implements StudentSubjectsService {

    private JpaStudentSubjectsRepository repo;

    public StudentSubjectsServiceImpl(JpaStudentSubjectsRepository repo){
        this.repo=repo;
    }

    @Override
    public List<StudentSubjects> getByStudentId(Long stuId) {
        return repo.findByStudentId(stuId);
    }

    @Override
    public List<StudentSubjects> getByStudentIdAndSemesterId(Long stuId, Long semId) {
        return repo.findByStudentIdAndSemesterId(stuId,semId);
    }
}
