package be.azz.java.ulfgarstoolbox.common.dtos.spellSchool.responses;

public record SpellSchoolResponse(
        String name,
        String title,
        boolean canBeForbidden,
        Integer numberForbiddenSchool,
        String image
) {
}
