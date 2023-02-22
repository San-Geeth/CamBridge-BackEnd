package com.example.cambridge.entity.student;

import com.example.cambridge.entity.classes.Claz;
import com.example.cambridge.entity.classes.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author sangeethnawa
 * @createdOn 2/22/2023
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_courses")
public class StudentCourses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "studentId")
    private Student student;
    @OneToOne
    @JoinColumn(name = "courseId")
    private Course course;
}
