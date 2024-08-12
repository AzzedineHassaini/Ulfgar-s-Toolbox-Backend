package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.ISpellHistoryService;
import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellHistoryResponse;
import be.azz.java.ulfgarstoolbox.common.mappers.SpellMapper;
import be.azz.java.ulfgarstoolbox.dal.repositories.SpellHistoryRepository;
import be.azz.java.ulfgarstoolbox.dal.specifications.SpellHistorySpecification;
import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SpellHistoryServiceImpl implements ISpellHistoryService {

    private final SpellHistoryRepository spellHistoryRepository;
    private final SpellMapper spellMapper;

    @Override
    public PagedResponse<SpellHistoryResponse> getSpellHistory(Map<String, String> params, int page, int pageSize, String sortField, int sortOrder) {
        Sort sort = Sort.unsorted();
        if (sortField != null && !sortField.isEmpty()) {
            sort = Sort.by(Sort.Direction.fromString(sortOrder == 1 ? "ASC" : "DESC"), sortField);
        }

        if (pageSize == 0) {
            // Récupérer tous les éléments
            List<SpellHistory> allSpells = spellHistoryRepository.findAll(SpellHistorySpecification.filterByParams(params), sort);
            return new PagedResponse<>(
                    allSpells.stream().map(spellMapper::fromEntity).toList(),
                    0,
                    (long) allSpells.size(),
                    1
            );
        } else {
            // Pagination normale
            Pageable pageable = PageRequest.of(page, pageSize, sort);
            Page<SpellHistory> pagedSpells = spellHistoryRepository.findAll(SpellHistorySpecification.filterByParams(params), pageable);
            return spellMapper.fromPageToHistory(pagedSpells);
        }
    }
}
