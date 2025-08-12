package org.wliamp.profile.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wliamp.profile.model.Friend;

public interface FriendRepo extends ReactiveMongoRepository<String, Friend> {
}
