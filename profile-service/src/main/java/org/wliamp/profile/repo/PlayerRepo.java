package org.wliamp.profile.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wliamp.profile.model.Player;

public interface PlayerRepo extends ReactiveMongoRepository<String, Player> {
}
