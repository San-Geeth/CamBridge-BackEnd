package com.example.cambridge.service.impl;

import com.example.cambridge.entity.classes.Course;
import com.example.cambridge.repo.classes.CourseRepo;
import com.example.cambridge.service.classes.CourseService;
import com.example.cambridge.utility.ResponseWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sangeethnawa
 * @createdOn 2/22/2023
 */
@Service
public class CourseImpl implements CourseService {

    private Logger logger = LogManager.getLogger(CourseImpl.class);

    private CourseRepo courseRepo;

    public CourseImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public ResponseEntity saveCourse(Course course) {
        course.setCreatedAt(new Date());
        courseRepo.save(course);
        logger.info("New course created --> : " + course);
        return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(course));
    }
}
