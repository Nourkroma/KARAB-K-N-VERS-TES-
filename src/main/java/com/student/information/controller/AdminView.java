package com.student.information.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.student.information.dto.ImageData;
import com.student.information.dto.Student;
import com.student.information.service.Admin_service;
import com.student.information.service.StorageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminView {

    @Autowired
    private Admin_service admin_service;

    @PostMapping("/newstudent")
    public ResponseEntity<String> addStudent(@RequestBody  @Valid Student student) throws IOException {
        return admin_service.addStudent(student);
    }

    @PostMapping("/addimage")
    public ResponseEntity<String> addImage(@RequestParam("image") MultipartFile image ,@RequestParam("email") String email) throws IOException {
        System.out.println("email : " + email);
        return admin_service.addImage(image,email);
    }
}
