package org.wliamp.profile.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wliamp.profile.document.Zone;

public interface ZoneRepo extends ReactiveMongoRepository<Zone, String> {}
