package ru.kata.spring.boot_security.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Set<Role> findRolesByUserId(long id);
}