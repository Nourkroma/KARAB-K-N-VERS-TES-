package com.student.information.dto;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentResponse {
    
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

    private String passport_no;

    private String passport;

    private String registration_date;

    private String last_session_date;

    private byte[] image;

    private String duration_of_study;

    private String Language_of_the_study;

    private PdfDocument full_information;

    private PdfDocument study_plan;

    private PdfDocument student_grades;

    private String id;

    private String email;

    // IF WE USE THE CODE
    private String secret;

    private String certificateName;

    private String certificateNumber;

    private String averageScore;

    private String education;

    private String description;
}
