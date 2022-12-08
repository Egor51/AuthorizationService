package com.app.authorizationservice.repository;

import com.app.authorizationservice.model.Authorities;
import com.app.authorizationservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final static Map<String, User> map = new ConcurrentHashMap<>();


    public UserRepository() {

        map.put("bob", new User("bob", "qwerty", Arrays.asList(Authorities.READ, Authorities.WRITE)));
        map.put("jack", new User("jack", "123456", Arrays.asList(Authorities.READ, Authorities.WRITE, Authorities.DELETE)));
        map.put("men", new User("men", "123456", Arrays.asList(Authorities.READ)));

    }


    public List<Authorities> getUserAuthorities(String user, String password) {
        List<Authorities> foundUserAuthoities = null;
        if (map.containsKey(user) && map.get(user).getPassword().equals(password)) {
            foundUserAuthoities = map.get(user).getAuthoritiesList();
        }
        return foundUserAuthoities;
    }
}