package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
