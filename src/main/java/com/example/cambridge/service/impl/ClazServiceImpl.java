package com.example.cambridge.service.impl;

import com.example.cambridge.entity.classes.AssignStudentsRequest;
import com.example.cambridge.entity.classes.Claz;
import com.example.cambridge.entity.classes.Constants;
import com.example.cambridge.entity.student.Student;
import com.example.cambridge.entity.student.StudentClasses;
import com.example.cambridge.repo.classes.ClazRepo;
import com.example.cambridge.repo.student.StudentClassesRepo;
import com.example.cambridge.repo.student.StudentRepo;
import com.example.cambridge.service.classes.ClazService;
import com.example.cambridge.utility.ResponseWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

@Service
public class ClazServiceImpl implements ClazService {

    private Logger logger = LogManager.getLogger(ClazServiceImpl.class);

    private final ClazRepo clazRepo;
    private final StudentClassesRepo stdClazRepo;
    private final StudentRepo studentRepo;

    public ClazServiceImpl(ClazRepo clazRepo, StudentClassesRepo stdClazRepo,
                           StudentRepo studentRepo) {
        this.clazRepo = clazRepo;
        this.stdClazRepo = stdClazRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public ResponseEntity saveClass(Claz claz)  {
        try {
            claz.setCreatedAt(new Date());
            clazRepo.save(claz);
            logger.info("New class created : " + claz);
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(claz));
        } catch (Exception e) {
            logger.warn(e.getMessage());
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseFail(Constants.ERROR_SAVING));
        }
    }

    public ResponseEntity getAllStudentsOfClass(Integer classId) {
        Optional<Claz> claz = clazRepo.findById(classId);
        if (!claz.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ResponseWrapper<>()
                            .responseFail(Constants.NO_CLASS_FOUND));
        }
        List<StudentClasses> studentList = stdClazRepo.getAllStudentsInClass(classId);
        if (!studentList.isEmpty()) {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(studentList));
        } else {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(Constants.NO_STUDENTS_FOUND));
        }
    }

    @Override
    public ResponseEntity assignStudentsToClass(AssignStudentsRequest request, Integer classId) {
        List<Student> studentList = studentRepo.getAllStudentsByIds(request.getStudentList());
        List<StudentClasses> newStudentList = new ArrayList<>();
        if (!studentList.isEmpty()) {
            for (Student student: studentList) {
                StudentClasses newStudentToClass = stdClazRepo.save(new StudentClasses(
                        student,
                        new Claz(classId)
                ));
                newStudentList.add(newStudentToClass);
            }
        }

        return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(newStudentList));
    }

    public ResponseEntity getAllClasses() {
        List<Claz> classes;
        classes = clazRepo.getAllClasses();
        return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(classes));

    }
}
