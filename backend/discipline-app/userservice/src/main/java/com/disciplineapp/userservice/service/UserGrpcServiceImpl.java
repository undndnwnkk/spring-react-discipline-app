package com.disciplineapp.userservice.service;

import com.disciplineapp.userservice.model.User;
import com.disciplineapp.userservice.repository.UserRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.grpc.server.service.GrpcService;
import users.CreateUserRequest;
import users.CreateUserResponse;
import users.UserServiceGrpc;

@GrpcService
@RequiredArgsConstructor
public class UserGrpcServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    private final UserRepository userRepository;

    @Override
    public void createUser(CreateUserRequest request, StreamObserver<CreateUserResponse> responseObserver) {
        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password_hash(request.getPasswordHash())
                .name(request.getName())
                .age(request.getAge())
                .weight(request.getWeight())
                .height(request.getHeight())
                .build();
        user =  userRepository.save(user);
        String userId = user.getId().toString();

        responseObserver.onNext(CreateUserResponse.newBuilder().setId(userId).build());
        responseObserver.onCompleted();
    }
}
