package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repo.UserRepo;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;


    @Autowired
    UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public void create(User user) {
        userRepo.save(user);
    }

    @Override
    public User read(long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    @Override
    public List<User> readAll() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public void update(User updateUser) {
        userRepo.save(updateUser);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByName(username);
    }
}
