package vn.chuot96.rediscache.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.chuot96.rediscache.dto.*;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class DataService {
    private final ReactiveRedisTemplate<String, CacheHolderDTO> reactiveRedisTemplate;

    public Mono<Void> save(String key, DataCache dto) {
        return reactiveRedisTemplate
                .opsForValue()
                .set(key, new CacheHolderDTO(key, dto), Duration.ofDays(30))
                .then();
    }

    public Mono<CacheHolderDTO> find(String key) {
        return reactiveRedisTemplate.opsForValue().get(key);
    }

    public Mono<Void> remove(String key) {
        return reactiveRedisTemplate.delete(key).then();
    }
}
