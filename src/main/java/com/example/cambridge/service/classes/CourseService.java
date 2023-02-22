package com.example.cambridge.service.classes;

import com.example.cambridge.entity.classes.Course;
import org.springframework.http.ResponseEntity;

/**
 * @author sangeethnawa
 * @createdOn 2/22/2023
 */
public interface CourseService {
    ResponseEntity saveCourse(Course course);
}
