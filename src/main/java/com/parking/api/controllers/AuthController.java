package com.parking.api.controllers;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.api.requests.AuthRequest;
import com.parking.domain.services.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public String login(@Valid @RequestBody AuthRequest authRequest) {
        try {
            return authService.checkLogin(authRequest);
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
