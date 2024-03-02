package com.student.information.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.student.information.dto.Student;
import com.student.information.dto.StudentResponse;

@Repository
public interface Student_Repo extends MongoRepository <Student, String>{

    Optional<Student> findById(String id);
    Optional<Student> findByEmail(String email);
    Optional<Student> findByName(String name);

}
