package com.example.cambridge.repo.student;

import com.example.cambridge.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
