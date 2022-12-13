package com.app.authorizationservice.exeotion;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super("[ERROR: UnauthorizedUser] : " + msg);
    }
}