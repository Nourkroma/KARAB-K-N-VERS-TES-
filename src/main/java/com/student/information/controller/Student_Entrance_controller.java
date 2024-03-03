package com.student.information.controller;

import org.springframework.web.bind.annotation.RestController;

import com.student.information.dto.Student;
import com.student.information.dto.StudentResponse;
import com.student.information.service.Student_Entrance_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class Student_Entrance_controller {

    @Autowired
    private Student_Entrance_service student_entrance_service;

    @GetMapping("/fulldata")
    public ResponseEntity<StudentResponse> getStudentData(@RequestParam Student s) {
        return student_entrance_service.getStudentData(s);
    }


}
