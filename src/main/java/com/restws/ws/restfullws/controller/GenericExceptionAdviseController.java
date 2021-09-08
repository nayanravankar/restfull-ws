package com.restws.ws.restfullws.controller;

import com.restws.ws.restfullws.bean.ResponseException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class GenericExceptionAdviseController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExcpetion(Exception e , WebRequest wr){
        ResponseException responseException = new ResponseException(e.getMessage(), wr.getDescription(true), new Date());
        return new ResponseEntity(responseException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseException responseException = new ResponseException(ex.getMessage(), ex.getBindingResult().toString(), new Date());
        return new ResponseEntity(responseException, HttpStatus.BAD_REQUEST);
    }
}
