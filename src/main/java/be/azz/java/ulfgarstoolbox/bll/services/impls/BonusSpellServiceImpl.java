package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.IBonusSpellService;
import be.azz.java.ulfgarstoolbox.common.dtos.bonusSpell.responses.BonusSpellResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.bonusSpell.BonusSpellNotFoundException;
import be.azz.java.ulfgarstoolbox.common.mappers.BonusSpellMapper;
import be.azz.java.ulfgarstoolbox.dal.repositories.BonusSpellRepository;
import be.azz.java.ulfgarstoolbox.domain.entities.BonusSpell;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BonusSpellServiceImpl implements IBonusSpellService {

    private final BonusSpellRepository bonusSpellRepository;
    private final BonusSpellMapper bonusSpellMapper;

    @Override
    public List<BonusSpellResponse> getAll() {
        return bonusSpellRepository.findAll()
                .stream()
                .map(bonusSpellMapper::fromEntity)
                .toList();
    }

    @Override
    public BonusSpellResponse getByAbilityScore(Integer abilityScore) {
        BonusSpell bonusSpell = bonusSpellRepository.findByAbilityScore(abilityScore)
                .orElseThrow(BonusSpellNotFoundException::new);
        return bonusSpellMapper.fromEntity(bonusSpell);
    }
}
