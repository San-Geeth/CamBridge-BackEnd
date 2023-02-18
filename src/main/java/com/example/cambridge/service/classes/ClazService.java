package com.example.cambridge.service.classes;

import com.example.cambridge.entity.classes.Claz;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface ClazService {
    ResponseEntity saveClass(Claz claz) throws ParseException;
}
