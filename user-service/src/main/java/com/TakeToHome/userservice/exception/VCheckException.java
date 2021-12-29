package com.TakeToHome.userservice.exception;

public class VCheckException extends RuntimeException{

    private String message;

    public VCheckException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}