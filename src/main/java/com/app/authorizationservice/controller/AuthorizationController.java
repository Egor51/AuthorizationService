package com.app.authorizationservice.controller;

import com.app.authorizationservice.exeotion.InvalidCredentials;
import com.app.authorizationservice.exeotion.UnauthorizedUser;
import com.app.authorizationservice.model.Authorities;
import com.app.authorizationservice.model.User;
import com.app.authorizationservice.service.AuthorizationService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;

@RestController
public class AuthorizationController {
    final AuthorizationService service;


    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }


    @GetMapping("/authorize")
    public List<Authorities> getAuthorities( @RequestParam("user") String user,
                                            @NonNull@RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials (InvalidCredentials e) {
        return new ResponseEntity<>( "Exception: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> handleUnauthorizedUser (UnauthorizedUser e) {
        return new ResponseEntity<>("[ERROR: UnauthorizedUser] : " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

}