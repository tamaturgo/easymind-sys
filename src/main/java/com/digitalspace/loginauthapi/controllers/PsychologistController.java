package com.digitalspace.loginauthapi.controllers;

import com.digitalspace.loginauthapi.domain.user.User;
import com.digitalspace.loginauthapi.dto.PsychologistRegisterRequestDTO;
import com.digitalspace.loginauthapi.dto.LoginResponseDTO;
import com.digitalspace.loginauthapi.infra.security.TokenService;
import com.digitalspace.loginauthapi.services.PsychologistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/psychologist")
@RequiredArgsConstructor
public class PsychologistController {
    private final PsychologistService psychologistService;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> register(@RequestBody PsychologistRegisterRequestDTO body) {
        try {
            User newUser = psychologistService.createUserFromDto(body);
            psychologistService.createPsychologistFromDto(newUser, body);

            String token = tokenService.generateToken(newUser);
            return ResponseEntity.ok(new LoginResponseDTO(newUser.getName(), token, newUser.getRole()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
