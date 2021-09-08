package com.restws.ws.restfullws.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//by default 500 internal server error thrown
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception {

    public UserNotFoundException(String msg){
        super(msg);
    }
}
