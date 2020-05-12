package com.example.demo.repository;

import com.example.demo.models.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JpaSemesterRepository extends JpaRepository<Semester,Long> {

    List<Semester> findAll();

    Optional<Semester> findById(Long id);

    Semester findFirstByOrderByOverallSemesterNoDesc();

    @Query("SELECT MAX(s.overallSemesterNo) FROM Semester s")
    Long getMaxOverallSemesterNo();
}
