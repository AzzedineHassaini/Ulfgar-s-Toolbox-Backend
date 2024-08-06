package be.azz.java.ulfgarstoolbox.common.dtos.spell.responses;

public record SpellShortResponse(
        Integer id,
        String name,
        String school,
        String components,
        String classLevels,
        String domainLevels
) {
}
