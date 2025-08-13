package org.wliamp.profile.model;

import java.util.Map;
import lombok.Data;

@Data
public class Equipment {
    private String code;
    private String tab;
    private String positive;
    private Map<String, Long> stats;
}
