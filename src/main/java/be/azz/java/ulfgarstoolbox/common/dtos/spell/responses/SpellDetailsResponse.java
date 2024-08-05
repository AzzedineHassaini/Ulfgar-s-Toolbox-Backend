package be.azz.java.ulfgarstoolbox.common.dtos.spell.responses;

import lombok.Builder;

@Builder
public record SpellDetailsResponse(
        Integer id,
        String name,
        String levels,
        String school,
        String schoolComplement,
        String description,
        String savingThrow,
        String castingTime,
        String range,
        String targets,
        String effect,
        String duration,
        String spellResistance,
        String components
) {
}
