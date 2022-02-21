package com.botkoda.netology.demo.Exception;

import lombok.Data;

@Data
public class ExceptionAnswer {
    private String message;
    private int id;

    public ExceptionAnswer(String message, int id) {
        this.message = message;
        this.id = id;
    }
}
