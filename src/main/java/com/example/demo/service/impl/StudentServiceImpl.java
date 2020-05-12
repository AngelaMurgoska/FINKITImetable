package com.example.demo.service.impl;

import com.example.demo.models.Student;
import com.example.demo.repository.JpaStudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private JpaStudentRepository repo;

    public StudentServiceImpl(JpaStudentRepository repo){
        this.repo=repo;
    }

    @Override
    public Student getByStuIndex(Long index) {
        return repo.findByStudentindex(index);
    }

    @Override
    public Student getByStuEmail(String email) {
        return repo.findByEmail(email);
    }
}
