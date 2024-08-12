package be.azz.java.ulfgarstoolbox.bll.services;

import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellHistoryResponse;

import java.util.Map;

public interface ISpellHistoryService {

    PagedResponse<SpellHistoryResponse> getSpellHistory(Map<String, String> params, int page, int pageSize, String sortField, int sortOrder);

}
