package com.example.cambridge.controller.student;

import com.example.cambridge.entity.student.Student;
import com.example.cambridge.service.student.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService userService) {
        this.studentService = userService;
    }
    @PostMapping("/save")
    public ResponseEntity saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/get/student/{id}")
    public ResponseEntity getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/get/student/grade/{grade}")
    public ResponseEntity getStudentsByGrade(@PathVariable Integer grade) {
        return studentService.getStudentsByGrade(grade);
    }

    @GetMapping("/get-by-index/student/{index}")
    public ResponseEntity getStudentByIndex(@PathVariable String index) {
        return studentService.getStudentByIndex(index);
    }


}
