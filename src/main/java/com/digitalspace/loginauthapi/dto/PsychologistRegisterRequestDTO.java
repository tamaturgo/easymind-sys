package com.digitalspace.loginauthapi.dto;

import java.time.LocalDate;

public record PsychologistRegisterRequestDTO(String name,
                                             String email,
                                             String password,
                                             String phone,
                                             String address,
                                             String crpState,
                                             String crpNumber,
                                             String crpType,
                                             String crpStatus,
                                             LocalDate crpValidity,
                                             String pixType,
                                             String pixValue) {
}
