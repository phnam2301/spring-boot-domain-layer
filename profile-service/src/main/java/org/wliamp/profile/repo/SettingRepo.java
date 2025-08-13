package org.wliamp.profile.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.wliamp.profile.document.Setting;

public interface SettingRepo extends ReactiveMongoRepository<Setting, String> {
}
