package com.example.cambridge.controller.classes;

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
}
