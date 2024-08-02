package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.spell.requests.SpellRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;

public interface ISpellService {

    SpellDetailsResponse addSpell(SpellRequest request);
    SpellDetailsResponse updateSpell(Integer id, SpellRequest request);
    SpellDetailsResponse deleteSpell(Integer id);

}
