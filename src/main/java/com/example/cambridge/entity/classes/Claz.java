package com.example.cambridge.entity.classes;

import com.example.cambridge.api.classes.ClassApi;
import com.example.cambridge.entity.staff.Teacher;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "class")
public class Claz implements ClassApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String subject;
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

    public Claz(Integer id, String subject) {
        this.id = id;
        this.subject = subject;
    }

    public Claz(Integer id) {
        this.id = id;
    }
}
