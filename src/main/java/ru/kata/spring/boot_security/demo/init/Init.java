package ru.kata.spring.boot_security.demo.init;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;
import javax.annotation.PostConstruct;

@Component
public class Init {

    private final UserService userService;
    private final RoleRepository roleRepository;

    public Init(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @PostConstruct
    private void init() {
        roleRepository.save(new Role(1L, "ROLE_ADMIN"));
        roleRepository.save(new Role(2L, "ROLE_USER"));
        userService.save(new User("admin", "admin", "admin", 33, "admin@mail.ru", "123", roleRepository.findAll()));
        userService.save(new User("user", "user1", "user2", 25, "user@mail.ru", "456", roleRepository.findById(2L).stream().toList()));
    }
}
