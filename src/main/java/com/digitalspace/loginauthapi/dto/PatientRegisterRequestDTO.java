package com.digitalspace.loginauthapi.dto;

import java.time.LocalDate;

public record PatientRegisterRequestDTO(String name,
                                        String email,
                                        String password,
                                        String phone,
                                        String address,
                                        String cpf,
                                        String rg,
                                        LocalDate birthDate,
                                        String civilState,
                                        String gender,
                                        Boolean firstTimeTreatment,
                                        Boolean hasChildren,
                                        Integer childrenQuantity,
                                        LocalDate treatmentStartDate) {
}
