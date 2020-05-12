package com.example.demo.service.impl;

import com.example.demo.models.Professor;
import com.example.demo.repository.JpaProfessorRepository;
import com.example.demo.service.ProfessorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private JpaProfessorRepository repo;

    public ProfessorServiceImpl(JpaProfessorRepository repo){
        this.repo=repo;
    }

    @Override
    public List<Professor> getAllProfessors() {
        return repo.findAll();
    }

    @Override
    public Professor getProfessorByName(String name) {
        return repo.findByName(name);
    }
}
