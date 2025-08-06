package vn.chuot96.rediscache.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import vn.chuot96.rediscache.dto.AuthDTO;
import vn.chuot96.rediscache.dto.CacheHolderDTO;
import vn.chuot96.rediscache.service.CacheService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cache")
public class Controller {
    private final CacheService cacheService;

    @PostMapping("/auth")
    public Mono<ResponseEntity<CacheHolderDTO>> auth(@RequestBody AuthDTO request) {
        return cacheService.cache(request);
    }
}
