package com.iraperec.ppSpringBoot.initialize;

import com.iraperec.ppSpringBoot.model.Role;
import com.iraperec.ppSpringBoot.model.User;
import com.iraperec.ppSpringBoot.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Set;
@Component
public class DBInitialization {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public DBInitialization(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");

        Role userRole = new Role();
        userRole.setName("ROLE_USER");

        User admin = new User();
        admin.setUsername("admin");
        admin.setAge(30);
        admin.setPassword("admin");
        admin.setRoles(Set.of(adminRole));
        passwordEncoder.encode("admin");

        User user = new User();
        user.setUsername("user");
        user.setPassword("user");
        user.setRoles(Set.of(userRole));
        user.setAge(9);
        passwordEncoder.encode("user");

        userService.save(admin);
        userService.save(user);
    }
}
