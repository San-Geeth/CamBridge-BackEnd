package com.example.cambridge.entity.student;

import com.example.cambridge.api.student.StudentApi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student implements StudentApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String indexNo;
    private String firstName;
    private String lastName;
    private Integer grade;
    private String parent;
    private String contact;

}
