package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.bonusSpell.responses.BonusSpellResponse;

import java.util.List;

public interface IBonusSpellService {

    List<BonusSpellResponse> getAll();

    BonusSpellResponse getByAbilityScore(Integer abilityScore);

}
