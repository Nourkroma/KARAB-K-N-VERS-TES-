package com.student.information.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Document(collection = "students")
public class Student {

    @Id
    private String id;

    
    private String email;


    private String password;

    
    private String name;

    
    private String registration_type;

  
    private String nationality;


    private String father_name;

    
    private String mother_name;

    private String birth_date;

   
    private String gender;

    
    private String cell_phone;

  
    private String address;

   
    private String town;

    private String address_country;
    
    private String situation;

    private String studentId;

    private String state;

    private String passport_no;

    private String passport;

    private String registration_date;

    private String last_session_date;

    private String image;

    private String duration_of_study;

    private String study_language;

    private String full_information;

    private String study_plan;

    private String student_grades;

    // IF WE USE THE CODE
    private String secret;

    private String certificateName;

    private String certificateNumber;

    private String averageScore;

    private String education;

    private String description;

}
