package com.disciplineapp.authservice.dto;

public record RegistrationResponse(
        String userId,
        String accessToken
) {
}
