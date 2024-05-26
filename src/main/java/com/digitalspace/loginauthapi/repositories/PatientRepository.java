package com.digitalspace.loginauthapi.repositories;

import com.digitalspace.loginauthapi.domain.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
