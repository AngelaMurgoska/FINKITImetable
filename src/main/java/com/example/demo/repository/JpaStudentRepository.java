package com.example.demo.repository;

import com.example.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaStudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentindex(Long index);

    Student findByEmail(String email);

}
