package com.disciplineapp.userservice.service;

import com.disciplineapp.userservice.dto.CreateUserDto;
import com.disciplineapp.userservice.model.User;
import com.disciplineapp.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public CreateUserDto createUser(CreateUserDto createUserDto) {
        User user = User.builder()
                .username(createUserDto.username())
                .email(createUserDto.email())
                .password_hash(createUserDto.password_hash())
                .name(createUserDto.name())
                .age(createUserDto.age())
                .weight(createUserDto.weight())
                .height(createUserDto.height())
                .build();

        user = userRepository.save(user);

        return mapToCreateUserDto(user);
    }

    private CreateUserDto mapToCreateUserDto(User user) {
        return CreateUserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password_hash(user.getPassword_hash())
                .name(user.getName())
                .age(user.getAge())
                .weight(user.getWeight())
                .height(user.getHeight())
                .build();
    }
}
