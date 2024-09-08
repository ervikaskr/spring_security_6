package com.spring.auth.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class UserController {

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> helloAdmin() {
        return ResponseEntity.ok("Hello Admin");
    }

    @PreAuthorize("hasAuthority('EMP')")
    @GetMapping("/user")
    public ResponseEntity<String> helloEmp() {
        return ResponseEntity.ok("Hello Emp");
    }
}