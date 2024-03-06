package com.student.information.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.student.information.dto.CodeResponse;
import com.student.information.dto.Student;
import com.student.information.repo.Student_Repo;

@Service
public class DocumentVerification_service {

    @Autowired
    private Student_Repo student_repo;

    public ResponseEntity<CodeResponse> getDocument(String secret) {
        if (secret == null)
            return ResponseEntity.badRequest().build();

        if (!student_repo.findBySecret(secret).isPresent())
            return ResponseEntity.badRequest().build();

        Optional<Student> student = student_repo.findBySecret(secret);
        CodeResponse codeResponse = codeResponseBuild(student.get());

        return ResponseEntity.ok(codeResponse);
    }

    private CodeResponse codeResponseBuild(Student student) {
        CodeResponse codeResponse = new CodeResponse();
        codeResponse.setCertificateName(student.getCertificateName());
        codeResponse.setCertificateNumber(student.getCertificateNumber());
        codeResponse.setAverageScore(student.getAverageScore());
        codeResponse.setEducation(student.getEducation());
        codeResponse.setDescription(student.getDescription());
        codeResponse.setName(student.getName());
        codeResponse.setStudentId(student.getStudentId());
        codeResponse.setImage(student.getImage());
        return codeResponse;
    }

}
