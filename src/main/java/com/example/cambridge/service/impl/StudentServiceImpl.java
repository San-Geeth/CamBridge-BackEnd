package com.example.cambridge.service.impl;

import com.example.cambridge.config.JwtService;
import com.example.cambridge.constants.ApplicationConstants;
import com.example.cambridge.entity.classes.Claz;
import com.example.cambridge.entity.student.Constants;
import com.example.cambridge.entity.student.Student;
import com.example.cambridge.entity.student.StudentClasses;
import com.example.cambridge.repo.classes.ClazRepo;
import com.example.cambridge.repo.student.StudentClassesRepo;
import com.example.cambridge.repo.student.StudentRepo;
import com.example.cambridge.service.student.StudentService;
import com.example.cambridge.utility.CommonMethods;
import com.example.cambridge.utility.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final ClazRepo clazRepo;
    private final StudentClassesRepo stdClassRepo;
    private final JwtService jwtService;

    public StudentServiceImpl(StudentRepo studentRepo, ClazRepo clazRepo, StudentClassesRepo stdClassRepo, JwtService jwtService) {
        this.studentRepo = studentRepo;
        this.clazRepo = clazRepo;
        this.stdClassRepo = stdClassRepo;
        this.jwtService = jwtService;
    }

    @Override
    public Student saveStudent(Student student) {
        Student stud = studentRepo.save(student);
        String index = Constants.STUDENT_INDEX_PREFIX + CommonMethods.formatNumber(stud.getId());
        studentRepo.updateIndex(index, stud.getId());
        if (!student.getClazList().isEmpty()) {
            List<Claz> classList = clazRepo.getClassesByIds(student.getClazList());
            if (!classList.isEmpty()) {
                for (Claz entity : classList)
                    stdClassRepo.save(new StudentClasses(
                            new Student(stud.getId()),
                            new Claz(entity.getId())
                    ));
            }
            System.out.println("Class List Is" + classList);
        }
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
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseFail(ApplicationConstants.STUDENT_NOT_FOUND));
        }
    }

    @Override
    public ResponseEntity getStudentByIndex(String index) {
        Student student = studentRepo.getStudentByIndex(index);
        if (student != null) {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(student));
        } else {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseFail(ApplicationConstants.STUDENT_NOT_FOUND));
        }
    }

}
