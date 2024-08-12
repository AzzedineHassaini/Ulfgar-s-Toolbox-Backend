package be.azz.java.ulfgarstoolbox.common.dtos.spell.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record SpellRequest(

        Map<Integer, Integer> classLevels,
        Map<Integer, Integer> domainLevels,
        @NotEmpty
        String name,
        @NotEmpty
        String school,
        String schoolComplement,
        @NotEmpty
        String description,
        String savingThrow,
        String components,
        String castingTime,
        String range,
        String effect,
        String duration,
        String spellResistance,
        String targets,
        @NotNull
        Long ruleBookId,
        @NotNull
        Integer page


) {
}
