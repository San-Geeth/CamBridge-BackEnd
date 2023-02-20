package com.example.cambridge.controller.classes;

import com.example.cambridge.entity.classes.AssignStudentsRequest;
import com.example.cambridge.entity.classes.Claz;
import com.example.cambridge.entity.staff.Teacher;
import com.example.cambridge.service.classes.ClazService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/class")
public class ClazController {

    private ClazService clazService;

    public ClazController(ClazService clazService) {
        this.clazService = clazService;
    }

    @PostMapping("/save")
    public ResponseEntity addNewClass(@RequestBody Claz claz) throws ParseException {
        return clazService.saveClass(claz);
    }

    @GetMapping("/get-all-students/class/{classId}")
    public ResponseEntity getAllStudentsOfClaz(@PathVariable Integer classId) {
        return clazService.getAllStudentsOfClass(classId);
    }

    @PostMapping("/assign-students/class/{classId}")
    public ResponseEntity assignStudentsToClass(@PathVariable Integer classId, @RequestBody AssignStudentsRequest request) {
        return clazService.assignStudentsToClass(request, classId);
    }

    @GetMapping("/get-list/all")
    public ResponseEntity getAllClasses() {
        return clazService.getAllClasses();
    }
}
