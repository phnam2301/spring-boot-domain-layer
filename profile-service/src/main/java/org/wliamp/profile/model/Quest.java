package org.wliamp.profile.model;

import java.util.Map;
import lombok.Data;

@Data
public class Quest {
    private Map<String, String> tasks;
    private long current;
}
