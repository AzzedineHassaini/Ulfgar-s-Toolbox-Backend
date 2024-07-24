package be.tftic.java.ulgarstoolbox.common.dtos.characterClass.responses;

public record CharacterClassResponse(
        Integer id,
        String name,
        Integer hitDice,
        Integer skillPoints,
        String spellCasterAbility,
        String magicType,
        Integer minimumGoldAtCreation,
        Integer maximumGoldAtCreation,
        String description
) {
}
