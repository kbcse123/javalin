package com.javalin.dao;

import com.javalin.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDao {

    private List<User> users = Arrays.asList(
            new User(0, "Steve Rogers"),
            new User(1, "Tony Stark"),
            new User(2, "Carol Danvers")
    );

    private static UserDao userDao = null;

    private UserDao() {
    }

    public static UserDao instance() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public Optional<User> getUserById(int id) {
        return users.stream()
                .filter(u -> u.id == id)
                .findAny();
    }

    public Iterable<String> getAllUsernames() {
        return users.stream()
                .map(user -> user.name)
                .collect(Collectors.toList());
    }
}
