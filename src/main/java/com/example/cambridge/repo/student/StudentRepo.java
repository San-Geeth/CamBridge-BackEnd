package com.example.cambridge.repo.student;

import com.example.cambridge.entity.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.id=:id")
    Student getStudentById(Integer id);

    @Query("SELECT s FROM Student s WHERE s.grade=:grade")
    List<Student> getStudentsByGrade(Integer grade);

    @Modifying
    @Transactional
    @Query("UPDATE Student s SET s.indexNo=:index WHERE s.id=:id")
    void updateIndex(String index, Integer id);

    @Query("SELECT s FROM Student s WHERE s.indexNo=:index")
    Student getStudentByIndex(String index);

    @Query("SELECT new Student(s.id) FROM Student s WHERE s.id in (:ids)")
    List<Student> getAllStudentsByIds(List<Integer> ids);
}
