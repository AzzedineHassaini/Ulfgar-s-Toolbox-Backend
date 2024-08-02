package be.azz.java.ulfgarstoolbox.common.dtos.spell.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record SpellRequest(

        @NotNull
        Map<Integer, Integer> classLevels,
        @NotNull
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
        String magicResistance,
        String targets,
        @NotNull
        Integer ruleBookId,
        @NotNull
        Integer page


) {
}
