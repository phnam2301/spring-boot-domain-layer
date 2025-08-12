package org.wliamp.profile.dto;

import java.util.List;
import java.util.Map;
import org.wliamp.profile.document.Player;

public record FriendDTO(Map<Player, List<Player>> friends) {}
