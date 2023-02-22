package com.example.cambridge.repo.classes;

import com.example.cambridge.entity.classes.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author sangeethnawa
 * @createdOn 2/22/2023
 */
public interface CourseRepo extends JpaRepository<Course, Integer> {
    @Query("SELECT new Course(c.id, c.course) FROM Course c WHERE c.id in (:ids)")
    List<Course> getCoursesByIds(List<Integer> ids);

}
