package com.matheus.userauth.services;

import com.matheus.userauth.domains.user.User;
import com.matheus.userauth.domains.user.UserRequestDTO;
import com.matheus.userauth.domains.user.UserResponseDTO;
import com.matheus.userauth.domains.user.UserRole;
import com.matheus.userauth.exception.codes.GlobalException;
import com.matheus.userauth.repositories.UserRepository;
import com.matheus.userauth.services.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testRegisterUser() {
        // Mock data
        UserRequestDTO userRequestDTO = new UserRequestDTO("username", "email@example.com", "password", UserRole.USER);
        User user = new User();
        user.setEmail(userRequestDTO.getEmail());
        user.setUsername(userRequestDTO.getUsername());
        user.setPassword("encodedPassword");

        // Mock behavior
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(passwordEncoder.encode(userRequestDTO.getPassword())).thenReturn("encodedPassword");

        // Test
        UserResponseDTO responseDTO = userService.registerUser(userRequestDTO);

        // Assertions
        assertEquals(user.getId(), responseDTO.id());
        assertEquals(user.getEmail(), responseDTO.email());
        assertEquals(user.getUsername(), responseDTO.username());
    }

    @Test
    void testRegisterUser_UsernameAlreadyExists() {
        // Mock data
        UserRequestDTO userRequestDTO = new UserRequestDTO("existingUsername", "email@example.com", "password",UserRole.USER);

        // Mock behavior
        when(userRepository.findByUsername(userRequestDTO.getUsername())).thenReturn(new User());

        // Test and assertion
        assertThrows(GlobalException.class, () -> userService.registerUser(userRequestDTO));
    }

    @Test
    void testRegisterUser_EmailAlreadyExists() {
        // Mock data
        UserRequestDTO userRequestDTO = new UserRequestDTO("username", "existingEmail@example.com", "password",UserRole.USER);

        // Mock behavior
        when(userRepository.findByEmail(userRequestDTO.getEmail())).thenReturn(new User());

        // Test and assertion
        assertThrows(GlobalException.class, () -> userService.registerUser(userRequestDTO));
    }
}