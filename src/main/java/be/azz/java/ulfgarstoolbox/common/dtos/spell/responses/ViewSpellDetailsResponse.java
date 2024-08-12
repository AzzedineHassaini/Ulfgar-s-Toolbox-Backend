package be.azz.java.ulfgarstoolbox.common.dtos.spell.responses;

import lombok.Builder;

@Builder
public record ViewSpellDetailsResponse(
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
        Long ruleBookId,
        Integer page,
        String bookName,
        String bookShortName,
        String classLevels,
        String domainLevels,
        String schoolImage
) {
}
