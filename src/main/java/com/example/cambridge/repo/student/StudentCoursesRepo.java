package com.example.cambridge.repo.student;

import com.example.cambridge.entity.student.StudentCourses;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author sangeethnawa
 * @createdOn 2/22/2023
 */
public interface StudentCoursesRepo extends JpaRepository<StudentCourses, Integer> {
}
