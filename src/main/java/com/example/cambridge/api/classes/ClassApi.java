package com.example.cambridge.api.classes;

import com.example.cambridge.entity.staff.Teacher;

import java.util.Date;

public interface ClassApi {
    public Integer getId();

    public void setId(Integer id);

    public String getSubject();

    public void setSubject(String subject);

    public String getDay();

    public void setDay(String day);

    public Date getTimeFrom();

    public void setTimeFrom(Date timeFrom);

    public Date getTimeTo();

    public void setTimeTo(Date timeTo);

    public String getHall();

    public void setHall(String hall);
    public Teacher getTeacher();

    public void setTeacher(Teacher teacher);

    public Date getCreatedAt();

    public void setCreatedAt(Date createdAt);

    public Date getLastUpdated();

    public void setLastUpdated(Date lastUpdated);

    public String getStartTime();

    public void setStartTime(String startTime);

    public String getEndTime();

    public void setEndTime(String endTime);
}
