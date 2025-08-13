package org.wliamp.profile.model;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
public class Figure {
    @Indexed(unique = true)
    private String code;

    private Map<String, Integer> abilities;
    private Map<String, Long> stats;
    private List<Equipment> equipments;
}
