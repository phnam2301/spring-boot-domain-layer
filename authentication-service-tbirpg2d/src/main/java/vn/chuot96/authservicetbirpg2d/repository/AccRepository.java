package vn.chuot96.authservicetbirpg2d.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import vn.chuot96.authservicetbirpg2d.entity.Acc;

public interface AccRepository extends ReactiveCrudRepository<Acc, Long> {
    Mono<Long> findIdByCredential(String credential);

    Mono<Acc> findByCredential(String credential);
}
