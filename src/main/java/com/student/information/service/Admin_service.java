package com.student.information.service;

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

        // if (student_repo.findByEmail(student.getEmail()) != null)
        //     return ResponseEntity.badRequest().body("Email already exists in database");

        // if (student_repo.findBySecret(student.getSecret()) != null)
        //     return ResponseEntity.badRequest().body("Secret already exists");

        student_repo.save(student).getId();
        return ResponseEntity.ok("Student added successfully");

    }

}
