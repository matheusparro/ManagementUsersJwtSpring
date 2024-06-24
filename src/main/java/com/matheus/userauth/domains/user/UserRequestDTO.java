package com.matheus.userauth.domains.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//create user record dto params
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO{
        @NotBlank(message = "Username is required")
        String username;

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        String email;

        @NotBlank(message = "Password is required")
        @Size(min = 6, message = "Password must be at least 6 characters long")
        String password;


        UserRole role;
 }
