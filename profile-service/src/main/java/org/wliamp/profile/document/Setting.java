package org.wliamp.profile.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "settings")
public class Setting {
    @Id
    private String id;

    private String locale;
    private int volume;
    private boolean muted;
}
