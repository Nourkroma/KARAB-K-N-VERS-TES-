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

    public ResponseEntity<CodeResponse> getDocument(String id) {
        if (id == null)
            return ResponseEntity.badRequest().build();

        if (!student_repo.existsById(id))
            return ResponseEntity.badRequest().build();

        Optional<Student> student = student_repo.findById(id);
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

        return codeResponse;
    }

}
