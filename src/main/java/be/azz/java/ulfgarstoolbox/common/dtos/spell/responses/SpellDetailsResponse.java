package be.azz.java.ulfgarstoolbox.common.dtos.spell.responses;

import jakarta.persistence.Column;
import lombok.Builder;

@Builder
public record SpellDetailsResponse(
        Integer id,
        String name,
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
        String components,
        Long idRuleBook,
        Integer page,
        String bookName,
        String bookShortName,
        String classLevels,
        String domainLevels
) {
}
