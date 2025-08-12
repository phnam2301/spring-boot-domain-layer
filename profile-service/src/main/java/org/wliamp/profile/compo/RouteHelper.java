package org.wliamp.profile.compo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.wliamp.profile.service.ProfileService;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RouteHelper {
    private final ProfileService profileService;

    public Mono<ServerResponse> load(ServerRequest request) {
        return profileService.loadProfile(request);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        return profileService.saveProfile(request);
    }

}
