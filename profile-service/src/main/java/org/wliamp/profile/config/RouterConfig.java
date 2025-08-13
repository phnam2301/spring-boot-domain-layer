package org.wliamp.profile.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.wliamp.profile.compo.RouteHelper;

@Configuration
@RequiredArgsConstructor
public class RouterConfig {
    private final RouteHelper helper;

    @Bean
    public RouterFunction<ServerResponse> profileRoutes() {
        return route().nest(path("/profile"), () -> route().nest(
                                path("/load"), () -> route().POST("/lobby", helper::loadLobby)
                                        .POST("/ingame", helper::loadIngame)
                                        .build())
                        .nest(path("/save"), () -> route().POST("", helper::save)
                                .build())
                        .build())
                .build();
    }
}
