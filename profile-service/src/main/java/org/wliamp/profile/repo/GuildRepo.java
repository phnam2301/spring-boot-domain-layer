package org.wliamp.profile.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wliamp.profile.model.Guild;

public interface GuildRepo extends ReactiveMongoRepository<String, Guild> {
}
