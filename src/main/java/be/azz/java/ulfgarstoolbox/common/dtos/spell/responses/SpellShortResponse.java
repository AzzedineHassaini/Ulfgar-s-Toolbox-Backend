package be.azz.java.ulfgarstoolbox.common.dtos.spell.responses;

public record SpellShortResponse(
        Integer id,
        String name,
        Integer level,
        String school,
        String components,
        String classLevels,
        String domainLevels
) {
}
