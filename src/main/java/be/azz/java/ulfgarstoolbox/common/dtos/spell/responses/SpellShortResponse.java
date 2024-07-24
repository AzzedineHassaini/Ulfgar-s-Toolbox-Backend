package be.azz.java.ulfgarstoolbox.common.dtos.spell.responses;

public record SpellShortResponse(
        Integer id,
        Integer classId,
        Integer domainId,
        String name,
        Integer level,
        String school,
        String components
) {
}
