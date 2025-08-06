package vn.chuot96.authservicetbirpg2d.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import vn.chuot96.authservicetbirpg2d.repository.AppRepository;

@Service
@RequiredArgsConstructor
public class AppService {
    private final AppRepository appRepository;

    public Mono<Long> findIdByCode(String code) {
        return appRepository.findIdByCode(code);
    }
}
