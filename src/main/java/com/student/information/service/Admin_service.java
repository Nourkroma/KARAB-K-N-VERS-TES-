package com.student.information.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.information.dto.Student;
import com.student.information.repo.Student_Repo;

@Service
public class Admin_service {

    @Autowired
    private Student_Repo student_repo;

    public ResponseEntity<String> addStudent(Student student) {

        if ((student.getEmail() == null || student.getPassword() == null) && (student.getSecret() == null))
            return ResponseEntity.badRequest().body("Email, Password and Secret are required fields");

        Optional<Student>s = student_repo.findByEmail(student.getEmail());

        if(s.isPresent())
            return ResponseEntity.badRequest().body("Email already exists in database");

        Optional<Student>s2 = student_repo.findBySecret(student.getSecret());

        if(s2.isPresent())
            return ResponseEntity.badRequest().body("Secret already exists");

        student_repo.save(student).getId();
        return ResponseEntity.ok("Student added successfully");

    }

}
