package be.azz.java.ulfgarstoolbox.common.dtos.bonusSpell.responses;

public record BonusSpellResponse(
    Integer id,
    Integer abilityScore,
    Integer modifier,
    Integer bonusSpellLvl0,
    Integer bonusSpellLvl1,
    Integer bonusSpellLvl2,
    Integer bonusSpellLvl3,
    Integer bonusSpellLvl4,
    Integer bonusSpellLvl5,
    Integer bonusSpellLvl6,
    Integer bonusSpellLvl7,
    Integer bonusSpellLvl8,
    Integer bonusSpellLvl9,
    boolean canCast
) {
}
