package org.wliamp.profile.model;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "players")
public class Player {
    @Id
    private String id;

    private Stats stats;
    private Server server;
    private BasicInfo info;
    private List<Character> characters;
    private List<Inventory> inventories;
    private List<Quest> quests;
}
