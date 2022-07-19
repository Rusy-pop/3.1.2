package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private UserService userService;

    @Autowired
    AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String saveUser(@ModelAttribute("newUser") User newUser) {
        newUser.setRoles(Collections.singleton(Role.USER));
        userService.createUser(newUser);
        return "redirect:/admin";
    }

    @GetMapping
    public String getAllUsers(Model model) {
        List<User> list = userService.findAllUsers();
        model.addAttribute("users", list);
        System.out.println(list);
        return "usersCrudOp";
    }

    @GetMapping("{id}")
    public String getUser(@PathVariable(name = "id") long id,
                          Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "update";
    }

    @PatchMapping("{id}")
    public String updateUser(@ModelAttribute("updateUser") User updateUser,
                             @PathVariable(name = "id") long id) {
        updateUser.setId(id);
        userService.updateUser(updateUser);
        return "redirect:/admin";
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
