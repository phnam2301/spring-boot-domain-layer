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
    public RouterFunction<ServerResponse> profileRoute() {
        return route().nest(path("/profile"), () -> route()
                        .POST("/load",  helper::load)
                        .POST("/save", helper::save)
                        .build())
                .build();
    }
}
