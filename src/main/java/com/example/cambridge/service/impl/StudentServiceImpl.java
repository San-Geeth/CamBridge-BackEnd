package com.example.cambridge.service.impl;

import com.example.cambridge.config.JwtService;
import com.example.cambridge.constants.ApplicationConstants;
import com.example.cambridge.entity.classes.Claz;
import com.example.cambridge.entity.student.Constants;
import com.example.cambridge.entity.student.Student;
import com.example.cambridge.entity.student.StudentClasses;
import com.example.cambridge.repo.classes.ClazRepo;
import com.example.cambridge.repo.student.StudentClassesRepo;
import com.example.cambridge.repo.student.StudentRepo;
import com.example.cambridge.service.student.StudentService;
import com.example.cambridge.utility.CommonMethods;
import com.example.cambridge.utility.ResponseWrapper;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    Environment environment;

    private Logger logger = LogManager.getLogger(StudentServiceImpl.class);
    private final StudentRepo studentRepo;
    private final ClazRepo clazRepo;
    private final StudentClassesRepo stdClassRepo;
    private final JwtService jwtService;

    public StudentServiceImpl(StudentRepo studentRepo, ClazRepo clazRepo, StudentClassesRepo stdClassRepo, JwtService jwtService) {
        this.studentRepo = studentRepo;
        this.clazRepo = clazRepo;
        this.stdClassRepo = stdClassRepo;
        this.jwtService = jwtService;
    }

    @Override
    public Student saveStudent(String firstName, String lastName, String grade,
                               String parent, String contact, MultipartFile image) {
        Student student = new Student(
                firstName,
                lastName,
                Integer.parseInt(grade),
                parent,
                contact
        );
        Student stud = studentRepo.save(student);
        if (!image.isEmpty()) {
            saveProfileImage(image, stud);
        }
        String index = Constants.STUDENT_INDEX_PREFIX + CommonMethods.formatNumber(stud.getId());
        studentRepo.updateIndex(index, stud.getId());
//        if (!clazList.isEmpty()) {
//            List<Claz> classList = clazRepo.getClassesByIds(clazList);
//            if (!classList.isEmpty()) {
//                for (Claz entity : classList)
//                    stdClassRepo.save(new StudentClasses(
//                            new Student(stud.getId()),
//                            new Claz(entity.getId())
//                    ));
//            }
//            System.out.println("Class List Is" + classList);
//        }
        return studentRepo.getStudentById(stud.getId());
    }

    @Override
    public ResponseEntity getStudentById(Integer id) {
        Student student = studentRepo.getStudentById(id);
        if (student != null) {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(student));
        } else {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(ApplicationConstants.STUDENT_NOT_FOUND));
        }
    }

    @Override
    public ResponseEntity getStudentsByGrade(Integer grade) {
        List<Student> studs = studentRepo.getStudentsByGrade(grade);
        if (!studs.isEmpty()) {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(studs));
        } else {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseFail(ApplicationConstants.STUDENT_NOT_FOUND));
        }
    }

    @Override
    public ResponseEntity getStudentByIndex(String index) {
        Student student = studentRepo.getStudentByIndex(index);
        if (student != null) {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseOk(student));
        } else {
            return ResponseEntity.ok().body(new ResponseWrapper<>().responseFail(ApplicationConstants.STUDENT_NOT_FOUND));
        }
    }

    private void saveProfileImage(MultipartFile profilePicture, Student student) {
        if (profilePicture != null) {
            try {

                Path imageFolder = Paths.get(Objects.requireNonNull(environment.getProperty("queue.storage.path"))
                        .concat(File.separator)
                        .concat("student")
                        .concat(File.separator));;

                if (!Files.exists(imageFolder)) {
                    Files.createDirectories(imageFolder);
                    logger.info("Directory created: " + imageFolder);
                }

                String extension = FilenameUtils.getExtension(profilePicture.getOriginalFilename());

                Files.deleteIfExists(Paths.get(imageFolder + student.getId().toString() +
                        "." + extension));

                Files.copy(profilePicture.getInputStream(), imageFolder.resolve(student.getId().toString()
                        + "." + extension), StandardCopyOption.REPLACE_EXISTING);

                String url = setImageUrl(student.getId(), extension);
                logger.info("User image url > " + url);
                student.setImage(url);
                logger.info(student);

            } catch (IOException e) {
                logger.error("Error occurring while saving the profile image.", e);
            }
        }
    }

    private String setImageUrl(Integer id, String imageExtension) {
        return id + "." + imageExtension;
    }

}
