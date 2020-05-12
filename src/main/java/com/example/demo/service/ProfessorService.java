package com.example.demo.service;

import com.example.demo.models.Professor;

import java.util.List;

public interface ProfessorService {

    List<Professor> getAllProfessors();

    Professor getProfessorByName(String name);
}
