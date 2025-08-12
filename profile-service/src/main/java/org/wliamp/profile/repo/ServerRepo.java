package org.wliamp.profile.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wliamp.profile.document.Zone;

public interface ServerRepo extends ReactiveMongoRepository<String, Zone> {}
