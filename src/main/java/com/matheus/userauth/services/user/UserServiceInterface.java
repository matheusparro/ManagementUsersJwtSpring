package com.matheus.userauth.services.user;

import com.matheus.userauth.domains.user.UserRequestDTO;
import com.matheus.userauth.domains.user.UserResponseDTO;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserServiceInterface {
     UserResponseDTO registerUser(UserRequestDTO userReq);

     UserDetails findByUsername(String username);
}
