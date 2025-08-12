package org.wliamp.profile.document;

import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "servers")
public class Zone {
    @Id
    private String id;

    private Date created;
    private List<Guild> guilds;
}
