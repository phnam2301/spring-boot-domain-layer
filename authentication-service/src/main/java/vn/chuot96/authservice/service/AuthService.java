package vn.chuot96.authservice.service;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;
import vn.chuot96.authservice.dto.UserRequestDTO;

public interface AuthService {
    Mono<Void> findUser(UserRequestDTO user);

    Mono<Void> insertUser(UserRequestDTO user);

    Mono<Void> updateUser(UserRequestDTO user);

    Mono<Void> deleteUser(UserRequestDTO user);

    Mono<ResponseEntity<String>> handleLogin(UserRequestDTO user);

    Mono<ResponseEntity<String>> handleLink(UserRequestDTO user);

    Mono<ResponseEntity<String>> handleRemove(UserRequestDTO user);
}
