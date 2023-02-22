package com.example.cambridge.controller.classes;

import com.example.cambridge.entity.classes.Course;
import com.example.cambridge.service.classes.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author sangeethnawa
 * @createdOn 2/22/2023
 */
@CrossOrigin
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/save")
    public ResponseEntity addNewClass(@RequestBody Course course)  {
        return courseService.saveCourse(course);
    }
}
