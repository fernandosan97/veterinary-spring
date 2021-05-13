package com.veterinary.veterinary.models;

import org.springframework.http.HttpStatus;

public class TokenModel {
    private String token;
    private HttpStatus status;

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return  status;
    }
}
