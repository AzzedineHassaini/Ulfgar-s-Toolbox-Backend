package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;

import java.util.List;

public interface ISpellService {

    SpellDetailsResponse getSpellDetails(Integer sortId);
    List<SpellShortResponse> getAllSpells();

}
