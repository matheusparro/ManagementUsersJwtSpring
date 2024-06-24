package com.matheus.userauth.services.user;

import com.matheus.userauth.domains.user.User;
import com.matheus.userauth.domains.user.UserRequestDTO;
import com.matheus.userauth.domains.user.UserResponseDTO;
import com.matheus.userauth.exception.codes.GlobalException;
import com.matheus.userauth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public UserResponseDTO registerUser(UserRequestDTO userReq){
        if(this.userRepository.findByUsername(userReq.getUsername()) != null || this.userRepository.findByEmail(userReq.getEmail()) != null){
            throw new GlobalException("Username or Email already exists", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setEmail(userReq.getEmail());
        user.setUsername(userReq.getUsername());
        user.setPassword(passwordEncoder.encode(userReq.getPassword()));
        user.setRole(userReq.getRole());

        this.userRepository.save(user);
        return new UserResponseDTO(user.getId(),user.getUsername(),user.getEmail());
    }

    @Override
    public UserDetails findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
