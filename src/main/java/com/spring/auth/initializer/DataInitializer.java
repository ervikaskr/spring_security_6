package com.spring.auth.initializer;

import com.spring.auth.model.Role;
import com.spring.auth.model.User;
import com.spring.auth.repository.RoleRepository;
import com.spring.auth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        roleRepository.deleteAll();


        Role role = new Role();
        role.setName("ADMIN");
        roleRepository.save(role);

        User user = new User();
        user.setName("John");
        user.setUsername("John6");
        user.setEmail("abc@gmail.com");
        user.setPassword("pass");

        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);

        System.out.println("User and Role initialized successfully!");
    }
}
