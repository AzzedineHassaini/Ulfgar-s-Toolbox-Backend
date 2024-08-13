package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.spell.requests.SpellRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.ViewSpellDetailsResponse;

public interface ISpellService {

    ViewSpellDetailsResponse addSpell(SpellRequest request);
    ViewSpellDetailsResponse updateSpell(Integer id, SpellRequest request);
    ViewSpellDetailsResponse deleteSpell(Integer id);

}
