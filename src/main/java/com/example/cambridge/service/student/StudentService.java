package com.example.cambridge.service.student;

import com.example.cambridge.entity.student.Student;
import org.springframework.stereotype.Service;

public interface StudentService {
    Student saveStudent(Student student);
}
