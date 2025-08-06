package vn.chuot96.authservicetbirpg2d.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import vn.chuot96.authservicetbirpg2d.entity.App;

public interface AppRepository extends ReactiveCrudRepository<App, Long> {
    Mono<Long> findIdByCode(String code);
}
