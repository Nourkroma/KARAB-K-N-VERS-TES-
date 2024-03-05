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
import com.student.information.service.PDFService;
import com.student.information.service.StorageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminView {

    @Autowired
    private Admin_service admin_service;

    @Autowired
    private PDFService pdfService;

    @PostMapping("/newstudent")
    public ResponseEntity<String> addStudent(@RequestBody @Valid Student student) {
        System.out.println(student);
        return admin_service.addStudent(student);
    }

    @PostMapping("/addimage")
    public ResponseEntity<String> addImage(@RequestParam("image") MultipartFile image,
            @RequestParam("email") String email) throws IOException {
        // System.out.println("email : " + email);
        return admin_service.addImage(image, email);
    }

    @PostMapping("/upload")
    public String uploadPDF(@RequestParam("full_information") MultipartFile file,
            @RequestParam("study_plan") MultipartFile file2, @RequestParam("student_grades") MultipartFile file3,
            @RequestParam("email") String email) {

        try {
            if (file != null)
                pdfService.compressAndSavePDF(file.getBytes(), file.getName(), email);
            if (file2 != null)
                pdfService.compressAndSavePDF(file2.getBytes(), file2.getName(), email);
            if (file3 != null)
                pdfService.compressAndSavePDF(file3.getBytes(), file3.getName(), email);

            if (file == null && file2 == null && file3 == null)
                return "No file uploaded";
            else
                return "File uploaded successfully";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload file";
        }
    }
}
