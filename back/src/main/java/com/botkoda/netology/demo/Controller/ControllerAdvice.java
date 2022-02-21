package com.botkoda.netology.demo.Controller;

import com.botkoda.netology.demo.Exception.ExceptionAnswer;
import com.botkoda.netology.demo.Exception.MyClientErrorException;
import com.botkoda.netology.demo.Exception.MyServerErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("com.botkoda.netology.demo")
public class ControllerAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MyServerErrorException.class)
    public ExceptionAnswer InvalidTransactExceptionHandler(MyServerErrorException ex) {
        return new ExceptionAnswer(ex.getMessage(), 0);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MyClientErrorException.class)
    public ExceptionAnswer InvalidTransactExceptionHandler(MyClientErrorException ex) {
        return new ExceptionAnswer(ex.getMessage(), 0);
    }
}
