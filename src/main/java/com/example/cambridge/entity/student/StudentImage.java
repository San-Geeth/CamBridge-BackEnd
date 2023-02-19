package com.example.cambridge.entity.student;

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
@Table(name = "student_image")
public class StudentImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String URL;
    @OneToOne
    @JoinColumn(name = "studnetId")
    private Student student;
}
