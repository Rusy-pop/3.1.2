package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    void save(User user);

    User findById(long userId);

    List<User> findAll();

    void update(User user);

    void deleteById(Long userId);
}
