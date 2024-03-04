package com.student.information.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.information.dto.Student;
import com.student.information.service.Admin_service;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminView {

    @Autowired
    private Admin_service admin_service;

    @PostMapping("/newstudent")
    public ResponseEntity<String> addStudent(@RequestBody  @Valid Student student) {
        return admin_service.addStudent(student);
    }
}
