package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;

@Controller("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public String getUserPage(){
        return "user";
    }
//
//    @PostConstruct
//    void defaultAdmin(){
//        User admin = new User("admin","@admin",(byte)33,"admin");
//        admin.setRoles(new HashSet<Role>(){{add(Role.ADMIN);add(Role.USER);}});
//        userService.create(admin);
//    }
}
