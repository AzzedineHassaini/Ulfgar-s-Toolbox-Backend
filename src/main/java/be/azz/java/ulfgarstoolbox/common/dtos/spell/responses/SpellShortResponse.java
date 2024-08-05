package be.azz.java.ulfgarstoolbox.common.dtos.spell.responses;

public record SpellShortResponse(
        Integer id,
        String name,
        String levels,
        String school,
        String components
) {
}
