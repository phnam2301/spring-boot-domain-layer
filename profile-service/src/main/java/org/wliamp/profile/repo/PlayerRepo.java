package org.wliamp.profile.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wliamp.profile.document.Player;

public interface PlayerRepo extends ReactiveMongoRepository<Player, String> {}
