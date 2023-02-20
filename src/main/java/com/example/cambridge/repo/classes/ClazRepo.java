package com.example.cambridge.repo.classes;

import com.example.cambridge.entity.classes.Claz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClazRepo extends JpaRepository<Claz, Integer> {
    @Query("SELECT new Claz(c.id, c.subject) FROM Claz c WHERE c.id in (:ids)")
    List<Claz> getClassesByIds(List<Integer> ids);

    @Query("SELECT new Claz(c.id, c.subject, c.teacher.firstName, c.teacher.lastName) FROM Claz c")
    List<Claz> getAllClasses();
}
