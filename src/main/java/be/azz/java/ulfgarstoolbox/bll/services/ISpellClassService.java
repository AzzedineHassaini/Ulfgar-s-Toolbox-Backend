package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;

import java.util.Map;

public interface ISpellClassService {

    PagedResponse<SpellShortResponse> findAll(Map<String, String> params, int page, int pageSize);

}