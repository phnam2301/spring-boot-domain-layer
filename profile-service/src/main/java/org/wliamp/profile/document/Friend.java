package org.wliamp.profile.document;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "friends")
public class Friend {
    @Id
    private String id;

    private Map<Player, List<Player>> friends;
}
