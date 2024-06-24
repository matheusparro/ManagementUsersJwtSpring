package com.matheus.userauth.domains.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserRole {
    ADMIN("admin"),

    USER("user");

    private String role;

}
