package vn.chuot96.authservicetbirpg2d.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import vn.chuot96.authservicetbirpg2d.dto.LinkRequestDTO;
import vn.chuot96.authservicetbirpg2d.dto.RequestDTO;
import vn.chuot96.authservicetbirpg2d.service.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class Controller {
    private final AuthService authService;

    @PostMapping("/guest")
    public Mono<ResponseEntity<?>> guest(@RequestBody RequestDTO request) {
        return authService.handleGuest(request);
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<?>> login(@RequestBody RequestDTO request) {
        return authService.handleLogin(request);
    }

    @PostMapping("/link")
    public Mono<ResponseEntity<?>> link(@RequestBody LinkRequestDTO request) {
        return authService.handleLink(request);
    }

    @PostMapping("/remove")
    public Mono<Void> remove(@RequestBody RequestDTO request) {
        return authService.handleRemove(request);
    }
}
