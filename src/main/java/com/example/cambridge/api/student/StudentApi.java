package com.example.cambridge.api.student;

/**
 * @author sangeethnawa
 * @createdOn 2/18/2023
 */
public interface StudentApi {
    public Integer getId();

    public void setId(Integer id);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getLastName();

    public void setLastName(String lastName);

    public Integer getGrade();

    public void setGrade(Integer grade);

    public String getParent();

    public void setParent(String parent);

    public String getContact();

    public void setContact(String contact);

    public String getIndexNo();

    public void setIndexNo(String indexNo);

}
