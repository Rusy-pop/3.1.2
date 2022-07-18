package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void createUser(User user);

    User findUserById(long userId);

    List<User> findAllUsers();

    void updateUser(User user);

    void deleteUser(long id);

    User findUserByUsername(String userName);
}
