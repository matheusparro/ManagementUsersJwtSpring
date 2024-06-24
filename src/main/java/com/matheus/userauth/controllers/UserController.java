package com.matheus.userauth.controllers;

import com.matheus.userauth.domains.user.UserRequestDTO;
import com.matheus.userauth.domains.user.UserResponseDTO;
import com.matheus.userauth.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userCreated = this.userService.registerUser(userRequestDTO);
        return ResponseEntity.ok(userCreated);

    }
    // retorna hello world
    @GetMapping
    public ResponseEntity<?> helloWorld() {
        return ResponseEntity.ok("Hello World");
    }

}
