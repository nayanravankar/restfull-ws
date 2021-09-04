package com.restws.ws.restfullws.controller;

import com.restws.ws.restfullws.bean.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/v1")
public class UserAPIController {

    @RequestMapping(method = RequestMethod.GET, path = "/getUser")
    public String getUser(){
        return "hey user";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/department/{userid}")
    public User getUserDepartment(@PathVariable("userid")  String userID){
        User user = new User();
        user.setUserId(userID);
        return user;
    }
}
