package com.example.cambridge.controller.staff;

import com.example.cambridge.entity.staff.Teacher;
import com.example.cambridge.entity.student.Student;
import com.example.cambridge.service.staff.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/staff")
public class StaffController {
    private StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/save/teacher")
    public ResponseEntity saveUser(@RequestBody Teacher teacher){
        return staffService.saveTeacher(teacher);
    }
}
