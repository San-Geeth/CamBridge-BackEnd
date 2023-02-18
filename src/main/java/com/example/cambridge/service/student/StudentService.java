package com.example.cambridge.service.student;

import com.example.cambridge.entity.student.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    Student saveStudent(Student student);

    ResponseEntity getStudentById(Integer id);

    ResponseEntity getStudentsByGrade(Integer grade);
    ResponseEntity getStudentByIndex(String index);
}
