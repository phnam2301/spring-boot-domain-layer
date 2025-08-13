package org.wliamp.profile.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wliamp.profile.document.Guild;

public interface GuildRepo extends ReactiveMongoRepository<Guild, String> {}
