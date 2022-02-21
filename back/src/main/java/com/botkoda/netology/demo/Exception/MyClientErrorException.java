package com.botkoda.netology.demo.Exception;

public class MyClientErrorException extends RuntimeException {
    public MyClientErrorException(String msg) {
        super(msg);
    }
}

