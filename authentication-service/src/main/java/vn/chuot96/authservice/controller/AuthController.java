package vn.chuot96.authservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import vn.chuot96.authservice.dto.UserRequestDTO;
import vn.chuot96.authservice.service.AuthService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public Mono<ResponseEntity<String>> login(@RequestBody UserRequestDTO user) {
        return authService.handleLogin(user);
    }

    @PostMapping("/link")
    public Mono<ResponseEntity<String>> link(@RequestBody UserRequestDTO user) {
        return authService.handleLink(user);
    }

    @PostMapping("/remove")
    public Mono<ResponseEntity<String>> remove(@RequestBody UserRequestDTO user) {
        return authService.handleRemove(user);
    }
}
