package vn.chuot96.rediscache.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.chuot96.rediscache.dto.CacheHolderDTO;
import vn.chuot96.rediscache.dto.DataCache;
import vn.chuot96.rediscache.util.RedisKeyCodec;

@Service
@RequiredArgsConstructor
public class CacheService {
    private final DataService dataService;

    public Mono<ResponseEntity<CacheHolderDTO>> cache(DataCache data) {
        String key = RedisKeyCodec.encode(data);
        return dataService
                .find(key)
                .flatMap(existing -> {
                    CacheHolderDTO updated = new CacheHolderDTO(key, data);
                    return dataService.save(key, updated.cache()).thenReturn(ResponseEntity.ok(updated));
                })
                .switchIfEmpty(dataService
                        .save(key, data)
                        .thenReturn(ResponseEntity.status(HttpStatus.CREATED).body(new CacheHolderDTO(key, data))));
    }
}
