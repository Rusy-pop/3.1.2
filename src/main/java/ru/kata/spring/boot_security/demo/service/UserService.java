package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void create(User user);

    User read(long userId);

    List<User> readAll();

    void update(User user);

    void delete(long id);
}
