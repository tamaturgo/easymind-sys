package com.digitalspace.loginauthapi.services;

import com.digitalspace.loginauthapi.domain.psychologist.Psychologist;
import com.digitalspace.loginauthapi.domain.user.User;
import com.digitalspace.loginauthapi.domain.user.UserRole;
import com.digitalspace.loginauthapi.dto.PsychologistRegisterRequestDTO;
import com.digitalspace.loginauthapi.repositories.PsychologistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PsychologistService {
    private final PsychologistRepository psychologistRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public User createUserFromDto(PsychologistRegisterRequestDTO dto) {
        userService.validateUserEmail(dto.email());
        userService.validateUserPassword(dto.password());
        userService.validatePhone(dto.phone());

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setPhone(dto.phone());
        user.setAddress(dto.address());
        user.setRole(UserRole.PSYCHOLOGIST);
        userService.validateUserEmail(dto.email());
        userService.saveUser(user);
        return user;
    }

    public void createPsychologistFromDto(User user, PsychologistRegisterRequestDTO dto) {
        Psychologist psychologist = new Psychologist();
        psychologist.setUser(user);
        psychologist.setCrpState(dto.crpState());
        psychologist.setCrpNumber(dto.crpNumber());
        psychologist.setCrpType(dto.crpType());
        psychologist.setCrpStatus(dto.crpStatus());
        psychologist.setCrpValidity(dto.crpValidity());
        psychologist.setPixType(dto.pixType());
        psychologist.setPixValue(dto.pixValue());
        psychologistRepository.save(psychologist);
    }
}
