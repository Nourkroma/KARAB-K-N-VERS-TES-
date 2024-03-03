package com.student.information.service;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.student.information.dto.Student;
import com.student.information.dto.StudentResponse;
import com.student.information.repo.Student_Repo;

@Service
public class Student_Entrance_service {

    @Autowired
    private Student_Repo student_repo;

    public ResponseEntity<StudentResponse> getStudentData(Student s) {
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

    public StudentResponse studentResponseBuild(Student student)
    {
        // attributes we have is : name , registration , nationality , father_name , mother_name , birth_date, gender , cell_phone , address , town , address_country , situation , passport_no , passport , registration_date , last_session_date , image , duration_of_study , Language_of_the_study , full_information , study_plan , student_grades
        StudentResponse response = new StudentResponse();
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
        response.setImage(student.getImage());
        response.setDuration_of_study(student.getDuration_of_study());
        response.setLanguage_of_the_study(student.getLanguage_of_the_study());
        response.setFull_information(student.getFull_information());
        response.setStudy_plan(student.getStudy_plan());
        response.setStudent_grades(student.getStudent_grades());
        return response;
    }
    
}
