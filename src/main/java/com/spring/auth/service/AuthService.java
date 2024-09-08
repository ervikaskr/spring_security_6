package com.spring.auth.service;

import com.spring.auth.dto.LoginRequest;
import com.spring.auth.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    public String getToken(LoginRequest loginRequest) {
        Authentication authentication = authenticateUser(loginRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return generateToken(authentication);
    }

    public Authentication authenticateUser(LoginRequest loginRequest) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()
        );
        return authenticationManager.authenticate(authentication);
    }

    public String generateToken(Authentication authentication) {
        return jwtUtil.generateToken(authentication);
    }



}