package com.example.cambridge.entity.classes;

import com.example.cambridge.entity.staff.Teacher;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sangeethnawa
 * @createdOn 2/22/2023
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String course;
    private String type;
    private String day;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "Asia/Colombo")
    @Temporal(TemporalType.TIME)
    private Date timeFrom;
    @JsonFormat(pattern = "HH:mm:ss", timezone = "Asia/Colombo")
    @Temporal(TemporalType.TIME)
    private Date timeTo;
    private String hall;
    @OneToOne
    @JoinColumn(name = "teacherId")
    private Teacher teacher;
    private Date createdAt;
    private Date lastUpdated;
    @Transient
    private String startTime;
    @Transient
    private String endTime;
    @Transient
    private String teacherFirstName;
    @Transient
    private String teacherLastName;

    public Course(Integer id, String course) {
        this.id = id;
        this.course = course;
    }

    public Course(Integer id) {
        this.id = id;
    }

    public Course(Integer id, String course, String teacherFirstName, String teacherLastName) {
        this.id = id;
        this.course = course;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
    }
}
