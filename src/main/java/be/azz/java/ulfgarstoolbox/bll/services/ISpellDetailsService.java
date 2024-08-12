package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.ViewSpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;

import java.util.Map;

public interface ISpellDetailsService {

    ViewSpellDetailsResponse getSpellDetails(Integer sortId);
    PagedResponse<SpellShortResponse> getAllSpells(Map<String, String> params, int page, int pageSize);
    SpellDetailsResponse getSpellDetailsForm(Integer sortId);

}
