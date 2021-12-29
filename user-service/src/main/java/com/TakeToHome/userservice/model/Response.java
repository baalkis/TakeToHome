package com.TakeToHome.userservice.model;

import org.springframework.http.HttpStatus;

public class Response {

    private HttpStatus status;
    private String message;

    public Response() {
        super();
    }

    public Response(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }


    public HttpStatus getStatus() {
        return status;
    }


    public void setStatus(HttpStatus status) {
        this.status = status;
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

}
