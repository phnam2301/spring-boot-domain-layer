package org.wliamp.profile.dto;

import java.util.Date;
import java.util.List;
import org.wliamp.profile.document.Guild;

public record ZoneDTO(Date created, List<Guild> guilds) {}
