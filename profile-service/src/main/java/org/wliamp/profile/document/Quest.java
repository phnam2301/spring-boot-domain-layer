package org.wliamp.profile.document;

import java.util.Map;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "quests")
public class Quest {
    @Id
    private String id;

    private String playerId;
    private Map<String, Long> tasks;
}
