package com.restws.ws.restfullws.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private Integer userId;

    private String name;

    @OneToMany(mappedBy = "userEntity")
    private List<PostEntity> postEntity;

    private Date dob;

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

    public List<PostEntity> getPostEntity() {
        return postEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostEntity(List<PostEntity> postEntity) {
        this.postEntity = postEntity;
    }
}
