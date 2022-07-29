package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("rest")
public class AdminRestController {
    private UserService userService;

    @Autowired
    AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.findAllUsers();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        userService.createUser(user);
        return userService.findUserById(user.getId());
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable long id,
                           @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
        return userService.findUserById(id);
    }

    @DeleteMapping("{id}")
    public String deleteUser (@PathVariable long id) {
        userService.deleteUser(id);
        return "redirect:/rest";
    }
}
