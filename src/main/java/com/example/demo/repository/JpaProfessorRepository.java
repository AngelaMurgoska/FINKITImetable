package com.example.demo.repository;

import com.example.demo.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaProfessorRepository extends JpaRepository<Professor,Long> {

    List<Professor> findAll();

    Professor findByName(String name);

}
