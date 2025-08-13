package org.wliamp.profile.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import org.wliamp.profile.document.Player;
import org.wliamp.profile.model.Figure;
import org.wliamp.profile.repo.*;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final PlayerRepo playerRepo;
    private final ReactiveRedisTemplate<String, Player> redisTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    // Load từ Redis, nếu cache miss thì load Mongo
    public Mono<Player> loadProfile(String playerId) {
        String key = "player:" + playerId;
        return redisTemplate
                .opsForValue()
                .get(key)
                .switchIfEmpty(playerRepo
                        .findById(playerId)
                        .flatMap(player ->
                                redisTemplate.opsForValue().set(key, player).thenReturn(player)));
    }

    // Merge snapshot từ Client
    public Mono<Player> saveProfile(String playerId, Player newData) {
        String key = "player:" + playerId;
        return loadProfile(playerId).flatMap(oldData -> {
            Player merged = mergePlayers(oldData, newData);
            return redisTemplate
                    .opsForValue()
                    .set(key, merged) // update cache
                    .then(saveToMongo(merged)); // update Mongo theo điều kiện
        });
    }

    // Thực tế save vào Mongo, có thể kiểm soát điều kiện
    private Mono<Player> saveToMongo(Player player) {
        // Điều kiện save: ví dụ mỗi 5 phút, hoặc client logout
        return playerRepo.save(player);
    }

    // Merge oldData + newData
    private Player mergePlayers(Player oldData, Player newData) {
        // merge field cơ bản
        if (newData.getGuildId() != null) oldData.setGuildId(newData.getGuildId());
        if (newData.getZoneId() != null) oldData.setZoneId(newData.getZoneId());
        if (newData.getStats() != null) oldData.getStats().putAll(newData.getStats());
        if (newData.getInventories() != null) oldData.getInventories().putAll(newData.getInventories());
        if (newData.getInformation() != null) oldData.getInformation().putAll(newData.getInformation());

        // merge figures
        Map<String, Figure> figureMap =
                oldData.getFigures().stream().collect(Collectors.toMap(Figure::getCode, f -> f));

        for (Figure f : newData.getFigures()) {
            if (figureMap.containsKey(f.getCode())) {
                Figure oldF = figureMap.get(f.getCode());
                if (f.getAbilities() != null) oldF.getAbilities().putAll(f.getAbilities());
                if (f.getStats() != null) oldF.getStats().putAll(f.getStats());
                if (f.getEquipments() != null) oldF.setEquipments(f.getEquipments());
            } else {
                oldData.getFigures().add(f);
            }
        }
        return oldData;
    }
}
