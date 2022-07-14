package ru.kata.spring.boot_security.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    UserDetails findByName(String username);
}
