package org.wliamp.profile.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class ProfileService {
    public Mono<ServerResponse> loadProfile(ServerRequest request) {
        return null;
    }

    public Mono<ServerResponse> saveProfile(ServerRequest request) {
        return null;
    }
}
