package com.example.cambridge.entity.staff;

import com.example.cambridge.api.staff.TeacherApi;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher implements TeacherApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String title;
    private String subject;
    private String contact;
    private String staffId;
    private Date savedAt;
}
