package com.example.demo.service.impl;


import com.example.demo.models.Semester;
import com.example.demo.repository.JpaSemesterRepository;
import com.example.demo.service.SemesterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterServiceImpl implements SemesterService{

    private JpaSemesterRepository repo;

    public SemesterServiceImpl(JpaSemesterRepository repo){
        this.repo=repo;
    }

    @Override
    public List<Semester> getAllSemesters() {
        return repo.findAll();
    }

    @Override
    public Optional<Semester> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public Semester save(Semester s) {
        return repo.save(s);
    }

    @Override
    public Semester getLatestSemester() {
        return repo.findFirstByOrderByOverallSemesterNoDesc();
    }

    @Override
    public Long getMaxOverallSemesterNo() {
        return repo.getMaxOverallSemesterNo();
    }
}
