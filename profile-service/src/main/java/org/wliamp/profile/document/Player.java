package org.wliamp.profile.document;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.wliamp.profile.model.*;

@Data
@Builder
@Document(collection = "players")
public class Player {
    @Id
    private String id;

    private String accountId;
    private String guildId;
    private String zoneId;
    private Map<String, Long> stats;
    private Map<String, Long> inventories;
    private Map<String, String> information;
    private List<Figure> figures;
}
