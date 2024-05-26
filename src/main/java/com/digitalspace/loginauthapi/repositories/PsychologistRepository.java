package com.digitalspace.loginauthapi.repositories;

import com.digitalspace.loginauthapi.domain.psychologist.Psychologist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PsychologistRepository extends JpaRepository<Psychologist, UUID> {

}
