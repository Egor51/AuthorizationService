package com.app.authorizationservice.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class User {
    private String login;
    private String password;
    private List<Authorities> authoritiesList;

    public User(String login, String password, List<Authorities> authoritiesList) {
    }
}