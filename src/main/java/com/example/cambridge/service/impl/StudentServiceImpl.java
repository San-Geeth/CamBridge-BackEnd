package com.example.cambridge.service.impl;

import com.example.cambridge.constants.ApplicationConstants;
import com.example.cambridge.entity.student.Constants;
import com.example.cambridge.entity.student.Student;
import com.example.cambridge.repo.student.StudentRepo;
import com.example.cambridge.service.student.StudentService;
import com.example.cambridge.utility.CommonMethods;
import com.example.cambridge.utility.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student saveStudent(Student student) {
        Student stud = studentRepo.save(student);
        String index = Constants.STUDENT_INDEX_PREFIX + CommonMethods.formatNumber(stud.getId());
        studentRepo.updateIndex(index, stud.getId());
        return studentRepo.getStudentById(stud.getId());
    }

    @Override
    public ResponseEntity getStudentById(Integer id) {
        Student student = studentRepo.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(student));
        } else {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(ApplicationConstants.STUDENT_NOT_FOUND));
        }
    }

    @Override
    public ResponseEntity getStudentsByGrade(Integer grade) {
        List<Student> studs = studentRepo.getStudentsByGrade(grade);
        if (!studs.isEmpty()) {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(studs));
        } else {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(ApplicationConstants.STUDENT_NOT_FOUND));
        }
    }

}
