package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller("/user")
public class UserController {

    private UserService userService;

    @Autowired
    UserController(UserService service){
        userService = service;
    }

    @GetMapping("/{id}")
    public String getUserPage(@PathVariable(name = "id") long id,
                              Model model){
        model.addAttribute("user", userService.read(id));
        return "user";
    }
}
