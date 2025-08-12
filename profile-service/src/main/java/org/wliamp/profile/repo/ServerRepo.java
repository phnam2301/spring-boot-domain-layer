package org.wliamp.profile.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wliamp.profile.model.Server;

public interface ServerRepo extends ReactiveMongoRepository<String, Server> {
}
