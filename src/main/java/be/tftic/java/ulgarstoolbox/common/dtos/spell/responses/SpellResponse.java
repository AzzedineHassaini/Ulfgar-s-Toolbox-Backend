package be.tftic.java.ulgarstoolbox.common.dtos.spell.responses;

public record SpellResponse(
        Integer id,
        Integer classId,
        Integer domainId,
        String name,
        Integer level,
        String school,
        String schoolComplement,
        String description,
        String savingThrow,
        String castingTime,
        String range,
        String targets,
        String effect,
        String duration,
        String magicResistance,
        String components
) {
}
