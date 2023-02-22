package com.example.cambridge.service.classes;

import com.example.cambridge.entity.classes.AssignStudentsRequest;
import com.example.cambridge.entity.classes.Claz;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface ClazService {
    ResponseEntity saveClass(Claz claz);

    ResponseEntity getAllStudentsOfClass(Integer classId);

    ResponseEntity assignStudentsToClass(AssignStudentsRequest request, Integer classId);

    ResponseEntity getAllClasses();
}
