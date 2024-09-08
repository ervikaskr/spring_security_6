package com.spring.auth.controller;

import com.spring.auth.dto.AuthResponseDto;
import com.spring.auth.dto.LoginRequest;
import com.spring.auth.dto.LoginRequest;
import com.spring.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/token")
    public ResponseEntity<AuthResponseDto> getToken(@RequestBody LoginRequest loginRequest){

        String token = authService.getToken(loginRequest);
        AuthResponseDto authResponseDto = new AuthResponseDto();
        authResponseDto.setAccessToken(token);

        return new ResponseEntity<>(authResponseDto, HttpStatus.OK);
    }
}