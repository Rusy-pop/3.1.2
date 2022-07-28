package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repo.UserRepo;

import java.util.List;
import java.util.Optional;

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
    public void createUser(User user) {
        userRepo.save(user);
    }

    @Override
    public User findUserById(long userId) {
        return userRepo.findById(userId).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public void updateUser(User updateUser) {
        Optional<User> optionalUser = userRepo.findById(updateUser.getId());

        if (optionalUser.isPresent()) {
            optionalUser.get().setUsername(updateUser.getUsername());
            optionalUser.get().setLastname(updateUser.getLastname());
            optionalUser.get().setPassword(updateUser.getPassword());
            optionalUser.get().setAge(updateUser.getAge());
            optionalUser.get().setEmail(updateUser.getEmail());

            optionalUser.get().getRoles().clear();
            optionalUser.get().getRoles().addAll(updateUser.getRoles());

            updateUser = optionalUser.get();
        }
        userRepo.save(updateUser);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("User not found");
        return user;
    }

    @Override
    public User findUserByUsername(String userName) {
        User user = userRepo.findUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
