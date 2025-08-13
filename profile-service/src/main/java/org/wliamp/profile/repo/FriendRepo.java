package org.wliamp.profile.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wliamp.profile.document.Friend;

public interface FriendRepo extends ReactiveMongoRepository<Friend, String> {}
