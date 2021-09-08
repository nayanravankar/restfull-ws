package com.restws.ws.restfullws.controller;

import com.restws.ws.restfullws.bean.User;
import com.restws.ws.restfullws.dao.UserServiceDao;
import com.restws.ws.restfullws.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserResourceController {

    @Autowired
    UserServiceDao userServiceDao;

    @GetMapping("/findAll")
    public List<User> findAllUser(){
        return userServiceDao.findAll();
    }

    @GetMapping("/findById/{id}")
    public User findbyID(@Validated @PathVariable("id") Integer id) throws UserNotFoundException {
        User user= userServiceDao.findById(id);
        if(user == null){
            throw new UserNotFoundException("user not found with id : "+id);
        }
        return user;
    }

    @PostMapping("/save")
    public EntityModel<User> save(@Valid @RequestBody User user) throws UserNotFoundException {
        User created= userServiceDao.save(user);
        EntityModel model = EntityModel.of(created);

        WebMvcLinkBuilder linktoFindAll = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).findAllUser());
        WebMvcLinkBuilder linktouserbyid = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).findbyID(user.getUserId()));
        model.add(linktoFindAll.withRel("all-user"));
        model.add(linktouserbyid.withRel("user-by-id"));
        return model;
    }

    @DeleteMapping("/delete/{id}")
    public User delete(@PathVariable("id") Integer id) throws UserNotFoundException {
        User user =  userServiceDao.deleteUserById(id);
        if(user == null){
            throw new UserNotFoundException("user not found with id : "+id);
        }
        return user;
    }
}
