package com.example.cambridge.service.impl;

import com.example.cambridge.constants.ApplicationConstants;
import com.example.cambridge.entity.classes.Claz;
import com.example.cambridge.repo.classes.ClazRepo;
import com.example.cambridge.service.classes.ClazService;
import com.example.cambridge.utility.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class ClazServiceImpl implements ClazService {

    private ClazRepo clazRepo;

    public ClazServiceImpl(ClazRepo clazRepo) {
        this.clazRepo = clazRepo;
    }

    @Override
    public Claz saveClass(Claz claz) throws ParseException {
        claz.setCreatedAt(new Date());
        return clazRepo.save(claz);
    }
}
