package com.app.authorizationservice.service;

import com.app.authorizationservice.model.Authorities;
import com.app.authorizationservice.exeotion.InvalidCredentials;
import com.app.authorizationservice.exeotion.UnauthorizedUser;
import com.app.authorizationservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository){this.userRepository = userRepository;}


    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}