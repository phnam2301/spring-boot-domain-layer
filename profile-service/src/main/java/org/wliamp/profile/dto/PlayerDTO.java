package org.wliamp.profile.dto;

import java.util.List;
import java.util.Map;
import org.wliamp.profile.model.Figure;

public record PlayerDTO(
        String accountId,
        String guildId,
        String zoneId,
        Map<String, Long> stats,
        Map<String, Long> inventories,
        Map<String, String> information,
        List<Figure> figures) {}
