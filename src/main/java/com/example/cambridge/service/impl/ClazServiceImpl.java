package com.example.cambridge.service.impl;

import com.example.cambridge.entity.classes.Claz;
import com.example.cambridge.entity.classes.Constants;
import com.example.cambridge.entity.student.StudentClasses;
import com.example.cambridge.repo.classes.ClazRepo;
import com.example.cambridge.repo.student.StudentClassesRepo;
import com.example.cambridge.service.classes.ClazService;
import com.example.cambridge.utility.ResponseWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClazServiceImpl implements ClazService {

    private Logger logger = LogManager.getLogger(ClazServiceImpl.class);

    private final ClazRepo clazRepo;
    private final StudentClassesRepo stdClazRepo;

    public ClazServiceImpl(ClazRepo clazRepo, StudentClassesRepo stdClazRepo) {
        this.clazRepo = clazRepo;
        this.stdClazRepo = stdClazRepo;
    }

    @Override
    public ResponseEntity saveClass(Claz claz) throws ParseException {
        claz.setCreatedAt(new Date());
        clazRepo.save(claz);
        logger.info("New class created : " + claz);
        return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(claz));
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
}
