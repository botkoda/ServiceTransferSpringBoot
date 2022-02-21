package com.botkoda.netology.demo.Exception;

public class MyServerErrorException extends RuntimeException{
    public MyServerErrorException(String msg) {
        super(msg);
    }
}
