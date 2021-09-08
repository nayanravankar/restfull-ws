package com.restws.ws.restfullws.dao;

import com.restws.ws.restfullws.bean.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserServiceDao {

    List<User> userLst = new ArrayList<>();
    {
        userLst.add(new User(1,"advika",new Date()));
        userLst.add(new User(2,"shal",new Date()));
        userLst.add(new User(3,"nayan",new Date()));
        userLst.add(new User(4,"advi",new Date()));
    }

    public List<User> findAll(){
        return userLst;
    }

    public User save(User user){
        userLst.add(user);
        return user;
    }
    public User findById(Integer id){
        for (User user : userLst){
            if(id.equals(user.getUserId())){
                return user;
            }
        }
        return null;
    }

    public User deleteUserById(Integer id){
        Iterator<User> itr = userLst.iterator();
        while(itr.hasNext()){
            User user = itr.next();
            if(id.equals(user.getUserId())){
                itr.remove();
                return user;
            }
        }
        return null;
    }
}
