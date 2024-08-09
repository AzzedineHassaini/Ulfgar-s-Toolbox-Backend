package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.ICharacterClassService;
import be.azz.java.ulfgarstoolbox.common.dtos.PagedResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassResponse;
import be.azz.java.ulfgarstoolbox.common.dtos.characterClass.responses.CharacterClassShortResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.characterClass.CharacterClassNotFoundException;
import be.azz.java.ulfgarstoolbox.common.mappers.CharacterClassMapper;
import be.azz.java.ulfgarstoolbox.dal.repositories.CharacterClassRepository;
import be.azz.java.ulfgarstoolbox.domain.entities.CharacterClass;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterClassServiceImpl implements ICharacterClassService {

    private final CharacterClassRepository characterClassRepository;
    private final CharacterClassMapper characterClassMapper;

    @Override
    public PagedResponse<CharacterClassShortResponse> findAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<CharacterClass> pagedClasses = characterClassRepository
                .findAll(pageable);

        return characterClassMapper.fromPage(pagedClasses);
    }

    @Override
    public CharacterClassResponse findById(int id) {
        return characterClassMapper.fromEntityToDetail(
                characterClassRepository.findById(id).
                        orElseThrow(CharacterClassNotFoundException::new)
        );
    }

    @Override
    public List<CharacterClassShortResponse> findAllCasterClasses() {
        return characterClassRepository
                .findAllSpellCastingClasses()
                .stream()
                .map(characterClassMapper::fromEntityToShort)
                .toList();
    }
}
