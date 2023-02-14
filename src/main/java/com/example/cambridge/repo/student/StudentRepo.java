package com.example.cambridge.repo.student;

import com.example.cambridge.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.id=:id")
    Student getStudentById(Integer id);
}
