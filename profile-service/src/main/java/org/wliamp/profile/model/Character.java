package org.wliamp.profile.model;

import java.util.List;
import lombok.Data;

@Data
public class Character {
    private String code;
    private Stats stats;
    private List<Ability> abilities;
    private List<Equipment> equipments;
}
