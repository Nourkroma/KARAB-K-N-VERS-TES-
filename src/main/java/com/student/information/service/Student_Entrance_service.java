package com.student.information.service;

import java.util.Base64;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.student.information.dto.Student;
import com.student.information.dto.StudentRequest;
import com.student.information.dto.StudentResponse;
import com.student.information.repo.Student_Repo;

@Service
public class Student_Entrance_service {

    @Autowired
    private Student_Repo student_repo;

    @Autowired
    private StorageService storageService;

    public ResponseEntity<StudentResponse> getStudentData(StudentRequest s) {
        String email = s.getEmail();
        String password = s.getPassword();
        Optional<Student> student = student_repo.findByEmailAndPassword(email, password);

        if (student.isPresent()) {
            Student student1 = student.get();
            StudentResponse response = studentResponseBuild(student1);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public StudentResponse studentResponseBuild(Student student) {

        StudentResponse response = new StudentResponse();

        if (student.getFull_information() != null) {
            byte[] full_info = Base64.getDecoder().decode(student.getFull_information());
            response.setFull_information(full_info);
        }
        if (student.getStudy_plan() != null) {
            byte[] study_plan = Base64.getDecoder().decode(student.getStudy_plan());
            response.setStudy_plan(study_plan);
        }
        if (student.getStudent_grades() != null) {
            byte[] student_grades = Base64.getDecoder().decode(student.getStudent_grades());
            response.setStudent_grades(student_grades);
        }

        if (student.getImage() != null) {
            byte[] img = storageService.downloadImage(student.getImage());
            response.setImage(img);
        }

        response.setName(student.getName());
        response.setRegistration_type(student.getRegistration_type());
        response.setNationality(student.getNationality());
        response.setFather_name(student.getFather_name());
        response.setMother_name(student.getMother_name());
        response.setBirth_date(student.getBirth_date());
        response.setGender(student.getGender());
        response.setCell_phone(student.getCell_phone());
        response.setAddress(student.getAddress());
        response.setTown(student.getTown());
        response.setAddress_country(student.getAddress_country());
        response.setSituation(student.getSituation());
        response.setPassport_no(student.getPassport_no());
        response.setPassport(student.getPassport());
        response.setRegistration_date(student.getRegistration_date());
        response.setLast_session_date(student.getLast_session_date());
        response.setDuration_of_study(student.getDuration_of_study());
        response.setStudy_language(student.getStudy_language());
        response.setId(student.getId());
        response.setEmail(student.getEmail());
        response.setSecret(student.getSecret());
        response.setCertificateName(student.getCertificateName());
        response.setCertificateNumber(student.getCertificateNumber());
        response.setAverageScore(student.getAverageScore());
        response.setEducation(student.getEducation());
        response.setDescription(student.getDescription());
        response.setState(student.getState());
        response.setStudentId(student.getStudentId());
        return response;
    }

}
