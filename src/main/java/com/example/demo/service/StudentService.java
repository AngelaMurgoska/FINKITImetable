package com.example.demo.service;

import com.example.demo.models.Student;

public interface StudentService {

    Student getByStuIndex(Long index);

    Student getByStuEmail(String email);
}
