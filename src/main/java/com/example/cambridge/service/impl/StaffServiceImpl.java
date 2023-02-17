package com.example.cambridge.service.impl;

import com.example.cambridge.entity.staff.Constants;
import com.example.cambridge.entity.staff.Teacher;
import com.example.cambridge.repo.staff.TeacherRepo;
import com.example.cambridge.service.staff.StaffService;
import com.example.cambridge.utility.CommonMethods;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StaffServiceImpl implements StaffService {

    private TeacherRepo teacherRepo;

    public StaffServiceImpl(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        Teacher teacherObj =  teacherRepo.save(teacher);
        teacher.setSavedAt(new Date());
        String staffId = Constants.TEACHER_ID_PREFIX + CommonMethods.formatNumber(teacherObj.getId());
        teacherRepo.updateIndex(staffId, teacherObj.getId());
        return teacherObj;
    }
}
