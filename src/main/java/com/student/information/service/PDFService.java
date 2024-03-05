package com.student.information.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.information.dto.Student;
import com.student.information.repo.Student_Repo;

import java.util.Base64;
import java.util.Optional;

@Service
public class PDFService {

    @Autowired
    private Student_Repo StudentRepo;

    @SuppressWarnings("null")
    public ResponseEntity<String> compressAndSavePDF(byte[] pdfBytes, String name, String email) {

        if (pdfBytes == null || email == null) {
            return ResponseEntity.badRequest().body("Email and PDF are required fields");
        }

        Optional<Student> student = StudentRepo.findByEmail(email);
        if (student.isEmpty()) {
            return ResponseEntity.badRequest().body("Student not found");
        }

        String compressedPDF = Base64.getEncoder().encodeToString(pdfBytes);
        System.out.println(name);
        if (name.equals("full_information")) {
            student.get().setFull_information(compressedPDF);
            System.out.println("full_information : " + student.get().getFull_information());
        }

        if (name.equals("study_plan")) {
            student.get().setStudy_plan(compressedPDF);
            System.out.println("study_plan : " + student.get().getStudy_plan());
        }

        if (name.equals("student_grades")) {
            student.get().setStudent_grades(compressedPDF);
            System.out.println("student_grades : " + student.get().getStudent_grades());
        }

        StudentRepo.save(student.get());

        return ResponseEntity.ok("PDF added successfully");
    }
}