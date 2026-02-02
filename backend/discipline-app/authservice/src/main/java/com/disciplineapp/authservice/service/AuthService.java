package com.disciplineapp.authservice.service;

import com.disciplineapp.authservice.dto.RegistrationRequest;
import com.disciplineapp.authservice.dto.RegistrationResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    // TODO get keycloak here

    public RegistrationResponse register(RegistrationRequest registrationRequest) {
        if (!validation(registrationRequest)) return null;


    }

    private boolean validation(RegistrationRequest request) {
        if (request.password().length() < 8) return false;
        if (request.age() < 0 || request.age() > 150) return false;
        if (request.weight() < 0 || request.weight() > 400) return false;
        if (request.height() < 0 || request.height() > 280) return false;
        return true;
    }
}
