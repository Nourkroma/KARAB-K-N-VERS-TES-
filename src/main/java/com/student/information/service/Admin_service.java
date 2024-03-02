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
        
        if (student != null)
        {
            student_repo.save(student).getId();
            return ResponseEntity.ok("Student added successfully");
        }
            
        else
            return ResponseEntity.badRequest().build();
    }


}
