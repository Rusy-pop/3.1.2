package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;
import java.util.Set;

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
    public String saveUser(@ModelAttribute("newUser") User newUser,
                           @RequestParam(required = false, name = "roles") Role role) {
        newUser.setRoles(Set.of(role));
        userService.createUser(newUser);
        return "redirect:/admin";
    }

    @GetMapping
    public String getAllUsers(@AuthenticationPrincipal User currentUser,
                              Model model) {
        List<User> list = userService.findAllUsers();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("users", list);
        System.out.println(list);
        return "admin";
    }

    @GetMapping("{id}")
    public String getUser(@PathVariable(name = "id") long id,
                          Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "update";
    }

    @PatchMapping
    public String updateUser(@RequestParam("ed-id") long id,
                             @RequestParam("ed-name") String name,
                             @RequestParam("ed-lastname") String lastname,
                             @RequestParam("ed-password") String password,
                             @RequestParam("ed-age") byte age,
                             @RequestParam("ed-email") String email,
                             @RequestParam(required = false, name = "ed-role") Role role) {

        User user = new User(name, lastname, password, email, age);
        user.setId(id);

        user.setRoles(Set.of(role));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping
    public String deleteUser(@RequestParam("del-id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
