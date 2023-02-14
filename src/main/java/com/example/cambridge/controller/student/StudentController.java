package com.example.cambridge.controller.student;

import com.example.cambridge.constants.ApplicationConstants;
import com.example.cambridge.entity.student.Student;
import com.example.cambridge.entity.user.User;
import com.example.cambridge.service.student.StudentService;
import com.example.cambridge.service.user.UserService;
import com.example.cambridge.utility.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService userService) {
        this.studentService = userService;
    }
    @PostMapping("/save")
    public ResponseEntity<Student> saveUser(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    @GetMapping("/get/student/{id}")
    public ResponseEntity getStudentById(@PathVariable Integer id) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(student));
        } else {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(ApplicationConstants.STUDENT_NOT_FOUND));
        }
    }

}
