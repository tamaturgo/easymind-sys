package com.digitalspace.loginauthapi.dto;
import com.digitalspace.loginauthapi.domain.user.UserRole;
public record ResponseDTO (String name, String token, UserRole role) { }