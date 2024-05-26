package com.digitalspace.loginauthapi.services;

import com.digitalspace.loginauthapi.domain.patient.Patient;
import com.digitalspace.loginauthapi.domain.psychologist.Psychologist;
import com.digitalspace.loginauthapi.domain.user.User;
import com.digitalspace.loginauthapi.domain.user.UserRole;
import com.digitalspace.loginauthapi.dto.PatientRegisterRequestDTO;
import com.digitalspace.loginauthapi.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public User createUserFromDto(PatientRegisterRequestDTO dto) {
        userService.validateUserEmail(dto.email());
        userService.validateUserPassword(dto.password());
        userService.validatePhone(dto.phone());

        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setPhone(dto.phone());
        user.setAddress(dto.address());
        user.setRole(UserRole.PATIENT);
        userService.validateUserEmail(dto.email());
        userService.saveUser(user);
        return user;
    }

    public void createPatientFromDto(User user, PatientRegisterRequestDTO dto) {
        Patient patient = new Patient();
        patient.setUser(user);
        patient.setCpf(dto.cpf());
        patient.setRg(dto.rg());
        patient.setBirthDate(dto.birthDate());
        patient.setCivilState(dto.civilState());
        patient.setGender(dto.gender());
        patient.setFirstTimeTreatment(dto.firstTimeTreatment());
        patient.setChildrenQuantity(dto.childrenQuantity());
        patient.setTreatmentStartDate(dto.treatmentStartDate());
        patientRepository.save(patient);
    }
}
