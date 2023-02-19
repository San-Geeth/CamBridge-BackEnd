package com.example.cambridge.service.student;

import com.example.cambridge.entity.student.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    Student saveStudent(String firstName, String lastName, String grade,
                        String parent, String contact, MultipartFile image);

    ResponseEntity getStudentById(Integer id);

    ResponseEntity getStudentsByGrade(Integer grade);
    ResponseEntity getStudentByIndex(String index);
}
