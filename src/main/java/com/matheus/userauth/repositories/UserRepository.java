package com.matheus.userauth.repositories;
import com.matheus.userauth.domains.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<User, String> {
    UserDetails findByUsername(String username);
    UserDetails findByEmail(String email);
}
