package com.example.cambridge.api.staff;

import java.util.Date;

public interface TeacherApi {
    public Integer getId();

    public void setId(Integer id);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public String getTitle();

    public void setTitle(String title);

    public String getSubject();

    public void setSubject(String subject);

    public String getContact();

    public void setContact(String contact);

    public String getStaffId();

    public void setStaffId(String staffId);

    public Date getSavedAt();

    public void setSavedAt(Date savedAt);
}
