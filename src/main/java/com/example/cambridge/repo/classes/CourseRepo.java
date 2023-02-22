package com.example.cambridge.repo.classes;

import com.example.cambridge.entity.classes.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sangeethnawa
 * @createdOn 2/22/2023
 */
public interface CourseRepo extends JpaRepository<Course, Integer> {
}
