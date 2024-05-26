package com.digitalspace.loginauthapi.controllers;

import com.digitalspace.loginauthapi.domain.user.User;
import com.digitalspace.loginauthapi.dto.PatientRegisterRequestDTO;
import com.digitalspace.loginauthapi.dto.LoginResponseDTO;
import com.digitalspace.loginauthapi.infra.security.TokenService;
import com.digitalspace.loginauthapi.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> register(@RequestBody PatientRegisterRequestDTO body) {
        try {
            User newUser = patientService.createUserFromDto(body);
            patientService.createPatientFromDto(newUser, body);
            String token = tokenService.generateToken(newUser);
            return ResponseEntity.ok(new LoginResponseDTO(newUser.getName(), token, newUser.getRole()));
        }
        catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
