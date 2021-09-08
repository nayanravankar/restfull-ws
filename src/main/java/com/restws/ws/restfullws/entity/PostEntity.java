package com.restws.ws.restfullws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class PostEntity {

    @Id
    @GeneratedValue
    private String postId;
    private String desc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore//to avoid recursion of user and post object
    private UserEntity userEntity;

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
