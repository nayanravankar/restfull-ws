package com.restws.ws.restfullws.controller;

import com.restws.ws.restfullws.entity.UserEntity;
import com.restws.ws.restfullws.entity.PostEntity;
import com.restws.ws.restfullws.exception.UserNotFoundException;
import com.restws.ws.restfullws.repo.PostRepository;
import com.restws.ws.restfullws.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users/v1")
public class UserAPIController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageSource messageSource;

     @Autowired
    PostRepository postRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/getUser")
    public String getUser(){

        return messageSource.getMessage("user.message",null,"default message", LocaleContextHolder.getLocale());
    }

   /* @RequestMapping(method = RequestMethod.GET, path = "/department/{userid}")
    public User getUserDepartment(@PathVariable("userid")  String userID){
        User user = new User();
        user.setUserId(Integer.valueOf(userID));
        return user;
    }*/

    @PostMapping("/add")
    public void creatUser(@RequestBody UserEntity userEntity){
        userRepository.save(userEntity);
    }

    @GetMapping("/get/{userID}")
    public UserEntity getUser(@PathVariable("userID") Integer userid){
        UserEntity userEntity= userRepository.findById(userid).get();
        return userEntity;
    }

    @GetMapping("/getAll")
    public List<UserEntity> getUserLst(){
        return userRepository.findAll();
    }
    //user dao services

    @DeleteMapping("/delete/{userID}")
    public void deleteUser(@PathVariable("userID") Integer userid){
         userRepository.deleteById(userid);
    }

    @PostMapping("/user/{userID}/post")
    public ResponseEntity<Object> createPost(@PathVariable("userID") Integer userID, @RequestBody PostEntity post ) throws UserNotFoundException {
        Optional<UserEntity> user =  userRepository.findById(userID);
        if(!user.isPresent()){
            throw new UserNotFoundException("user not found with id "+userID);
        }
        post.setUserEntity(user.get());
        postRepository.save(post);
        return null;
    }
}
