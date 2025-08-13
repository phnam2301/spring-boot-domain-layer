package org.wliamp.profile.compo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.wliamp.profile.document.Player;
import org.wliamp.profile.service.ProfileService;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class RouteHelper {
    private final ProfileService profileService;

    public Mono<ServerResponse> loadLobby(ServerRequest request) {
        String playerId = request.pathVariable("id");
        return profileService.loadProfile(playerId).flatMap(p -> ServerResponse.ok()
                .bodyValue(p));
    }

    public Mono<ServerResponse> loadIngame(ServerRequest request) {
        String playerId = request.pathVariable("id");
        return profileService.loadProfile(playerId).flatMap(p -> ServerResponse.ok()
                .bodyValue(p));
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        String playerId = request.pathVariable("id");
        return request.bodyToMono(Player.class)
                .flatMap(data -> profileService.saveProfile(playerId, data))
                .flatMap(p -> ServerResponse.ok().bodyValue(p));
    }
}
