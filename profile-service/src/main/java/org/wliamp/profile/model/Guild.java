package org.wliamp.profile.model;

import java.util.Map;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "guilds")
public class Guild {
    @Id
    private String id;

    private String name;
    private Stats stats;
    private Map<String, Player> players;
}
