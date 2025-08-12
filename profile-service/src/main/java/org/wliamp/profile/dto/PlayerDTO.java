package org.wliamp.profile.dto;

import java.util.List;
import org.wliamp.profile.document.Zone;
import org.wliamp.profile.model.*;
import org.wliamp.profile.model.Character;

public record PlayerDTO(
        Stats stats,
        Zone zone,
        FriendDTO info,
        List<Character> characters,
        List<Inventory> inventories,
        List<Quest> quests) {}
