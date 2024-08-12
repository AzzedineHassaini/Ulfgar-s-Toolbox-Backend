package be.azz.java.ulfgarstoolbox.common.dtos.spell.responses;

import java.util.Map;

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
        Long ruleBookId,
        Integer page,
        String bookName,
        String bookShortName,
        Map<Integer, Integer> classLevels,
        Map<Integer, Integer> domainLevels,
        String schoolImage
) {
}
