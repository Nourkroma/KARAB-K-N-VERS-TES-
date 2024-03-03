package com.student.information.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.information.dto.CodeResponse;
import com.student.information.service.DocumentVerification_service;

@RestController
@RequestMapping("/code")
@CrossOrigin(origins = "*")
public class DocumentVerification_controller {

    @Autowired
    private DocumentVerification_service documentVerification_service;


    @GetMapping("/document")
    public ResponseEntity<CodeResponse> getDocument(@RequestParam String secret) {
        return documentVerification_service.getDocument(secret);
    }
}
