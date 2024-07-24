package be.tftic.java.ulfgarstoolbox.bll.services;

import be.tftic.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.tftic.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;

import java.util.Map;

public interface ISpellDomainService {

    PagedResponse<SpellShortResponse> findAll(Map<String, String> params, int page, int pageSize);

}
