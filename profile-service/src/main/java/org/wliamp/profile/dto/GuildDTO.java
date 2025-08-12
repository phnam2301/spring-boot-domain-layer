package org.wliamp.profile.dto;

import java.util.Map;
import org.wliamp.profile.document.Player;
import org.wliamp.profile.model.Stats;

public record GuildDTO(String name, Stats stats, Map<String, Player> players) {}
