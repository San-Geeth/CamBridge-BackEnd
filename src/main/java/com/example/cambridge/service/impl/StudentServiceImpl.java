package com.example.cambridge.service.impl;

import com.example.cambridge.entity.student.Student;
import com.example.cambridge.repo.student.StudentRepo;
import com.example.cambridge.service.student.StudentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepo.getStudentById(id);
    }


}
