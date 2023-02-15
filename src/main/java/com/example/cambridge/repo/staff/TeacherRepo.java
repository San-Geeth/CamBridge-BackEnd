package com.example.cambridge.repo.staff;

import com.example.cambridge.entity.staff.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Teacher s SET s.staffId=:index WHERE s.id=:id")
    void updateIndex(String index, Integer id);
}
