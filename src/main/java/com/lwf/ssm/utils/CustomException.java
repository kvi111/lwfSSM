package com.lwf.ssm.utils;

/**
 * Created by lwf on 2017/3/1.
 */
public class CustomException extends Exception {
    private String message;

    public CustomException(){}

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
