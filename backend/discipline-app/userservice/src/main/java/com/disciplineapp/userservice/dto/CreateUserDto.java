package com.disciplineapp.userservice.dto;

import lombok.Builder;

@Builder
public record CreateUserDto(String username, String email, String password_hash, String name, Integer age, Float weight, Float height) {

}
