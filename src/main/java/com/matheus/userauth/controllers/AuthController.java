package com.matheus.userauth.controllers;

import com.matheus.userauth.configuration.TokenService;
import com.matheus.userauth.domains.user.AuthenticationDTO;
import com.matheus.userauth.domains.user.LoginResponseDTO;
import com.matheus.userauth.domains.user.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.remote.JMXAuthenticator;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamepassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());

        var auth = this.authenticationManager.authenticate(usernamepassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
