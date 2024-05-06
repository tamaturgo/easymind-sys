package com.digitalspace.loginauthapi.dto;

import com.digitalspace.loginauthapi.domain.user.UserRole;

public record RegisterRequestDTO (String name, String email, String password, UserRole role) {
}
