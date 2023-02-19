package com.example.cambridge.entity.student;

import com.example.cambridge.entity.classes.Claz;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author sangeethnawa
 * @createdOn 2/19/2023
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_classes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "studentId")
    private Student student;
    @OneToOne
    @JoinColumn(name = "classId")
    private Claz claz;

    @Transient
    private Integer studentId;
    @Transient
    private String studentFirstName , studentLastName, studentIndex;
    public StudentClasses(Student student, Claz claz) {
        this.student = student;
        this.claz = claz;
    }

    public StudentClasses(Integer studentId, String studentFirstName, String studentLastName, String studentIndex) {
        this.studentId = studentId;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentIndex = studentIndex;
    }
}
