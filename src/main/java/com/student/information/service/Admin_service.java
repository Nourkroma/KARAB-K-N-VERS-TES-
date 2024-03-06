package com.student.information.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.student.information.dto.ImageData;
import com.student.information.dto.Student;
import com.student.information.repo.Student_Repo;

@Service
public class Admin_service {

    @Autowired
    private Student_Repo student_repo;

    @Autowired
    private StorageService storageService;

    public ResponseEntity<String> addStudent(Student student) {

        if ((student.getEmail() == null || student.getPassword() == null) && (student.getSecret() == null))
            return ResponseEntity.badRequest().body("Email, Password and Secret are required fields");

        Optional<Student> s = student_repo.findByEmail(student.getEmail());

        if (s.isPresent())
            return ResponseEntity.badRequest().body("Email already exists in database");

        Optional<Student> s2 = student_repo.findBySecret(student.getSecret());

        if (s2.isPresent())
            return ResponseEntity.badRequest().body("Secret already exists");

        // System.out.println(student.getLanguage_of_the_study());

        student_repo.save(student).getId();
        return ResponseEntity.ok("Student added successfully");

    }

    @SuppressWarnings("null")
    public ResponseEntity<String> addImage(MultipartFile image,String email) throws IOException {
        if (email == null || image == null)
            return ResponseEntity.badRequest().body("Email and Image are required fields");

        Optional<Student> s = student_repo.findByEmail(email);
        if (s.isEmpty())
            return ResponseEntity.badRequest().body("Student not found");

        // ImageData imageBytes = storageService.uploadImage(image);
        // s.get().setImage(imageBytes);
        student_repo.save(s.get());

        return ResponseEntity.ok("Image added successfully");

    }
}
