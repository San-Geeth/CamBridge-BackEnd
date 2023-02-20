package com.example.cambridge.entity.student;

import com.example.cambridge.api.student.StudentApi;
import com.example.cambridge.entity.classes.Claz;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    private String address;
    private String image;
    @Transient
    private List<Integer> clazList;

    public Student(Integer id) {
        this.id = id;
    }

    public Student(String firstName, String lastName, Integer grade, String parent, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.parent = parent;
        this.contact = contact;
    }


}
