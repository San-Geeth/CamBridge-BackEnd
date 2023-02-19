package com.example.cambridge.repo.student;

import com.example.cambridge.entity.student.Student;
import com.example.cambridge.entity.student.StudentClasses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author sangeethnawa
 * @createdOn 2/19/2023
 */
public interface StudentClassesRepo extends JpaRepository<StudentClasses, Integer> {
    @Query("SELECT new StudentClasses(st.student.id, " +
            "st.student.firstName, st.student.lastName, st.student.indexNo) " +
            "FROM StudentClasses st WHERE st.claz.id=:classId")
    List<StudentClasses> getAllStudentsInClass(Integer classId);
}
