package com.disciplineapp.authservice.dto;

public record RegistrationRequest(
        String username,
        String email,
        String password,
        String name,
        Integer age,
        Float weight,
        Float height
) {
}
