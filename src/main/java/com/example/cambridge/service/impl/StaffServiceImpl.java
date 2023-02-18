package com.example.cambridge.service.impl;

import com.example.cambridge.entity.staff.Constants;
import com.example.cambridge.entity.staff.Teacher;
import com.example.cambridge.repo.staff.TeacherRepo;
import com.example.cambridge.service.staff.StaffService;
import com.example.cambridge.utility.CommonMethods;
import com.example.cambridge.utility.ResponseWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StaffServiceImpl implements StaffService {

    private TeacherRepo teacherRepo;
    private Logger logger = LogManager.getLogger(StaffServiceImpl.class);

    public StaffServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public ResponseEntity saveTeacher(Teacher teacher) {
        Teacher teacherObj =  teacherRepo.save(teacher);
        teacher.setSavedAt(new Date());
        String staffId = Constants.TEACHER_ID_PREFIX + CommonMethods.formatNumber(teacherObj.getId());
        teacherRepo.updateIndex(staffId, teacherObj.getId());
        logger.info("New teacher saved : " + teacherObj);
        return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(teacherObj));
    }
}
