package com.app.authorizationservice.controller;

import com.app.authorizationservice.model.Authorities;
import com.app.authorizationservice.service.AuthorizationService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AuthorizationController {
    final AuthorizationService service;


    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }


    @GetMapping("/authorize/")
    public List<Authorities> getAuthorities( @RequestParam("user") String user,
                                            @NonNull@RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }
    @GetMapping ("/test")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> test(){
        String test = "test";
        return new ResponseEntity<>(test,HttpStatus.OK);
    }
}