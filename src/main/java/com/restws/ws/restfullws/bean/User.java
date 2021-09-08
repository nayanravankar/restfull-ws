package com.restws.ws.restfullws.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class User {

    private Integer userId;


    @NotEmpty
    @Size(max = 64,min = 4, message = "name should be not be less than 4 char or more than 64 char")
    private String name;

   @JsonIgnore
    private Date dob;

    public User(Integer userId, String department, Date dob) {
        this.userId = userId;
        this.name = department;
        this.dob = dob;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
