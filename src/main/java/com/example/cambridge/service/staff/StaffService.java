package com.example.cambridge.service.staff;

import com.example.cambridge.entity.staff.Teacher;
import org.springframework.http.ResponseEntity;

public interface StaffService {
    ResponseEntity saveTeacher(Teacher teacher);
}
