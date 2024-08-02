package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.ISpellDetailsService;
import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.spells.SpellNotFoundException;
import be.azz.java.ulfgarstoolbox.common.mappers.SpellMapper;
import be.azz.java.ulfgarstoolbox.dal.repositories.SpellDetailsRepository;
import be.azz.java.ulfgarstoolbox.dal.specifications.SpellSpecifications;
import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SpellDetailsServiceImpl implements ISpellDetailsService {

    private final SpellDetailsRepository spellDetailsRepository;
    private final SpellMapper spellMapper;

    public SpellDetailsResponse getSpellDetails(Integer sortId) {
        SpellDetails result = spellDetailsRepository.findById(sortId)
                .orElseThrow(SpellNotFoundException::new);

        return spellMapper.fromEntityToDetails(result);
    }

    public PagedResponse<SpellShortResponse> getAllSpells(Map<String, String> params, int page, int pageSize) {

        if (pageSize == 0) {
            // Récupérer tous les éléments
            List<SpellDetails> allSpells = spellDetailsRepository.findAll(SpellSpecifications.filterByParams(params));
            return new PagedResponse<>(
                    allSpells.stream().map(spellMapper::fromEntityToShort).toList(),
                    0,
                    (long) allSpells.size(),
                    1
            );
        } else {
            // Pagination normale
            Pageable pageable = PageRequest.of(page, pageSize);
            Page<SpellDetails> pagedSpells = spellDetailsRepository.findAll(SpellSpecifications.filterByParams(params), pageable);
            return spellMapper.fromPage(pagedSpells);
        }
    }

}
