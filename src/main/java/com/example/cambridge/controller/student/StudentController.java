package com.example.cambridge.controller.student;

import com.example.cambridge.entity.student.Student;
import com.example.cambridge.service.student.StudentService;
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
        return studentService.getStudentById(id);
    }

    @GetMapping("/get/student/grade/{grade}")
    public ResponseEntity getStudentsByGrade(@PathVariable Integer grade) {
        return studentService.getStudentsByGrade(grade);
    }

}
