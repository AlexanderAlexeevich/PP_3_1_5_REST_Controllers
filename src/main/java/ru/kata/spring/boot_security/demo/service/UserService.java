package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findOne(Long id);
    void save(User user);
    void update(User user);
    void delete(Long id);
    User findByUsername(String username);
}
