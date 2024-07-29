package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.ISpellService;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellShortResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.spells.SpellNotFoundException;
import be.azz.java.ulfgarstoolbox.common.mappers.SpellMapper;
import be.azz.java.ulfgarstoolbox.dal.repositories.SpellRepository;
import be.azz.java.ulfgarstoolbox.domain.entities.tempTables.SpellDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpellServiceImpl implements ISpellService {

    private final SpellRepository spellRepository;
    private final SpellMapper spellMapper;

    public SpellDetailsResponse getSpellDetails(Integer sortId) {
        SpellDetails result = spellRepository.getSpellDetails(sortId)
                .orElseThrow(SpellNotFoundException::new);

        return spellMapper.fromEntityToDetails(result);
    }

    public List<SpellShortResponse> getAllSpells() {
        return spellRepository.getAllSpellDetails()
                .stream()
                .map(spellMapper::fromEntityToShort)
                .toList();
    }

}
