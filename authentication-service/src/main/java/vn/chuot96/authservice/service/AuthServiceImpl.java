package vn.chuot96.authservice.service;

import static vn.chuot96.authservice.constant.Message.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.chuot96.authservice.dto.UserRequestDTO;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final ForwardService forwardService;

    @Override
    public Mono<Void> findUser(UserRequestDTO user) {
        return forwardService.forwardFindUser(user).then(); // placeholder
    }

    @Override
    public Mono<Void> insertUser(UserRequestDTO user) {
        return forwardService.forwardInsertUser(user).then(); // placeholder
    }

    @Override
    public Mono<Void> updateUser(UserRequestDTO user) {
        return forwardService.forwardUpdateUser(user).then(); // placeholder
    }

    @Override
    public Mono<Void> deleteUser(UserRequestDTO user) {
        return forwardService.forwardDeleteUser(user).then(); // placeholder
    }

    @Override
    public Mono<ResponseEntity<String>> handleLogin(UserRequestDTO user) {
        return findUser(user)
                .map(u -> ResponseEntity.ok(LOGIN_SUCCESS.getMessage()))
                .switchIfEmpty(insertUser(user).thenReturn(ResponseEntity.ok(REGISTER_SUCCESS.getMessage())));
    }

    @Override
    public Mono<ResponseEntity<String>> handleLink(UserRequestDTO user) {
        return findUser(user)
                .flatMap(u -> updateUser(user).thenReturn(ResponseEntity.ok(LINK_SUCCESS.getMessage())))
                .switchIfEmpty(notFound(ACCOUNT_INVALID.getMessage()));
    }

    @Override
    public Mono<ResponseEntity<String>> handleRemove(UserRequestDTO user) {
        return findUser(user)
                .flatMap(u -> deleteUser(user).thenReturn(ResponseEntity.ok(REMOVE_SUCCESS.getMessage())))
                .switchIfEmpty(notFound(ACCOUNT_INVALID.getMessage()));
    }

    private Mono<ResponseEntity<String>> notFound(String msg) {
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg));
    }
}
