package org.wliamp.profile.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.wliamp.profile.document.Friend;
import org.wliamp.profile.dto.BundleDTO;
import org.wliamp.profile.repo.*;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final FriendRepo friendRepo;

    private final GuildRepo guildRepo;

    private final PlayerRepo playerRepo;

    private final ZoneRepo zoneRepo;

    private final SettingRepo settingRepo;

    public Mono<ServerResponse> loadProfile(ServerRequest request) {
        return null;
    }

    public Mono<Void> saveProfile(BundleDTO bundle) {
        return Mono.when(
                friendRepo.save(bundle.friend()),
                guildRepo.save(bundle.guild()),
                playerRepo.save(bundle.player()),
                zoneRepo.save(bundle.zone()),
                settingRepo.save(bundle.setting())
        ).then();
    }
}
