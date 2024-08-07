package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.ISpellSchoolService;
import be.azz.java.ulfgarstoolbox.common.dtos.spellSchool.responses.SpellSchoolResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.spellSchool.responses.SpellSchoolShortResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.spells.SpellNotFoundException;
import be.azz.java.ulfgarstoolbox.common.mappers.SpellSchoolMapper;
import be.azz.java.ulfgarstoolbox.dal.repositories.SpellSchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpellSchoolServiceImpl implements ISpellSchoolService {

    private final SpellSchoolRepository spellSchoolRepository;
    private final SpellSchoolMapper spellSchoolMapper;

    @Override
    public List<SpellSchoolShortResponse> getAllSpellSchools() {
        return spellSchoolRepository.findAll().stream().map(spellSchoolMapper::fromEntityToShort).toList();
    }

    @Override
    public SpellSchoolResponse getSpellSchoolById(Long id) {
        return spellSchoolMapper.fromEntity(spellSchoolRepository.findById(id).orElseThrow(SpellNotFoundException::new));
    }
}
