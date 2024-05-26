package com.digitalspace.loginauthapi.services;

import com.digitalspace.loginauthapi.domain.user.User;
import com.digitalspace.loginauthapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void validateUserEmail(String email) {
        if (isEmailRegistered(email)) {
            throw new IllegalArgumentException("Email is already registered");
        }
        if (!isEmailValid(email)) {
            throw new IllegalArgumentException("Email is not valid");
        }
    }

    public void validateUserPassword(String password) {
        if (!isPasswordValid(password)) {
            throw new IllegalArgumentException("Password must have at least 8 characters");
        }
    }

    public void validatePhone(String phone) {
        if (phone.length() < 10) {
            throw new IllegalArgumentException("Phone must have at least 10 characters");
        }
    }

    private boolean isEmailRegistered(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    private boolean isEmailValid(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }



}
