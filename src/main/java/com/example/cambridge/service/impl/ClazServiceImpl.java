package com.example.cambridge.service.impl;

import com.example.cambridge.entity.classes.Claz;
import com.example.cambridge.repo.classes.ClazRepo;
import com.example.cambridge.service.classes.ClazService;
import com.example.cambridge.utility.ResponseWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;

@Service
public class ClazServiceImpl implements ClazService {

    private Logger logger = LogManager.getLogger(ClazServiceImpl.class);

    private ClazRepo clazRepo;

    public ClazServiceImpl(ClazRepo clazRepo) {
        this.clazRepo = clazRepo;
    }

    @Override
    public ResponseEntity saveClass(Claz claz) throws ParseException {
        claz.setCreatedAt(new Date());
        clazRepo.save(claz);
        logger.info("New class created : " + claz);
        return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(claz));
    }
}
