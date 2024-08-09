package be.azz.java.ulfgarstoolbox.common.dtos.spell.responses;

import java.time.Instant;

public record SpellHistoryResponse(
    String spellName,
    String action,
    String updatedTable,
    String updatedField,
    String oldValue,
    String newValue,
    Instant date,
    String user
) {
}
