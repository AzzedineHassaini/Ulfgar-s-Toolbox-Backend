package be.azz.java.ulfgarstoolbox.bll.services.impls;

import be.azz.java.ulfgarstoolbox.bll.services.ISpellDetailsService;
import be.azz.java.ulfgarstoolbox.bll.services.ISpellService;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.requests.SpellRequest;
import be.azz.java.ulfgarstoolbox.common.dtos.spell.responses.SpellDetailsResponse;
import be.azz.java.ulfgarstoolbox.common.exceptions.characterClass.CharacterClassNotFoundException;
import be.azz.java.ulfgarstoolbox.common.exceptions.domain.DomainNotFoundException;
import be.azz.java.ulfgarstoolbox.common.exceptions.spells.SpellNotFoundException;
import be.azz.java.ulfgarstoolbox.common.mappers.SpellMapper;
import be.azz.java.ulfgarstoolbox.dal.repositories.*;
import be.azz.java.ulfgarstoolbox.domain.entities.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SpellServiceImpl implements ISpellService {

    private final SpellRepository spellRepository;
    private final CharacterClassRepository characterClassRepository;
    private final DomainRepository domainRepository;
    private final ISpellDetailsService spellDetailsService;
    private final SpellMapper spellMapper;


    @Override
    @Transactional
    public SpellDetailsResponse addSpell(SpellRequest request) {
        Spell newSpell = spellMapper.toEntity(request);
        newSpell.setSpellClass(getSpellClassFromRequest(request, newSpell));
        newSpell.setSpellDomains(getSpellDomainFromRequest(request, newSpell));
        newSpell = spellRepository.save(newSpell);
        return spellDetailsService.getSpellDetails(newSpell.getId());
    }

    @Override
    @Transactional
    public SpellDetailsResponse updateSpell(Integer id, SpellRequest request) {
        Spell spellToUpdate = spellRepository.findById(id).orElseThrow(SpellNotFoundException::new);
        spellMapper.updateEntityFromRequest(request, spellToUpdate);

        // Mettre à jour spellClass
        updateSpellClass(spellToUpdate, request);

        // Mettre à jour spellDomains
        updateSpellDomains(spellToUpdate, request);

        spellToUpdate = spellRepository.saveAndFlush(spellToUpdate);
        return spellDetailsService.getSpellDetails(spellToUpdate.getId());
    }

    @Override
    @Transactional
    public SpellDetailsResponse deleteSpell(Integer id) {
        Spell spell = spellRepository.findById(id).orElseThrow(SpellNotFoundException::new);
        SpellDetailsResponse spellDetailsResponse = spellDetailsService.getSpellDetails(id);
        // Les entités de SpellClass et SpellDomain liés à ce spell seront supprimées par cascade
        spellRepository.delete(spell);
        return spellDetailsResponse;
    }

    private void updateSpellClass(Spell spell, SpellRequest request) {
        Set<SpellClass> currentSpellClasses = spell.getSpellClass();
        Set<SpellClass> newSpellClasses = getSpellClassFromRequest(request, spell);

        // Supprimer les éléments qui ne sont plus présents
        currentSpellClasses.removeIf(spellClass ->
                newSpellClasses.stream().noneMatch(newSpellClass ->
                        newSpellClass.getCharacterClass().equals(spellClass.getCharacterClass())));

        // Ajouter ou mettre à jour les nouveaux éléments
        for (SpellClass newSpellClass : newSpellClasses) {
            Optional<SpellClass> existingSpellClass = currentSpellClasses.stream()
                    .filter(sc -> sc.getCharacterClass().equals(newSpellClass.getCharacterClass()))
                    .findFirst();

            if (existingSpellClass.isPresent()) {
                existingSpellClass.get().setLevel(newSpellClass.getLevel());
            } else {
                currentSpellClasses.add(newSpellClass);
            }
        }
    }

    private void updateSpellDomains(Spell spell, SpellRequest request) {
        Set<SpellDomain> currentSpellDomains = spell.getSpellDomains();
        Set<SpellDomain> newSpellDomains = getSpellDomainFromRequest(request, spell);

        // Supprimer les éléments qui ne sont plus présents
        currentSpellDomains.removeIf(spellDomain ->
                newSpellDomains.stream().noneMatch(newSpellDomain ->
                        newSpellDomain.getDomain().equals(spellDomain.getDomain())));

        // Ajouter ou mettre à jour les nouveaux éléments
        for (SpellDomain newSpellDomain : newSpellDomains) {
            Optional<SpellDomain> existingSpellDomain = currentSpellDomains.stream()
                    .filter(sd -> sd.getDomain().equals(newSpellDomain.getDomain()))
                    .findFirst();

            if (existingSpellDomain.isPresent()) {
                existingSpellDomain.get().setLevel(newSpellDomain.getLevel());
            } else {
                currentSpellDomains.add(newSpellDomain);
            }
        }
    }

    private Set<SpellClass> getSpellClassFromRequest(SpellRequest request, Spell spell) {
        return request.classLevels().entrySet().stream()
                .map(entry -> {
                    SpellClass spellClass = new SpellClass();
                    CharacterClass characterClass = characterClassRepository.findById(entry.getKey()).orElseThrow(CharacterClassNotFoundException::new);
                    spellClass.setCharacterClass(characterClass);
                    spellClass.setLevel(entry.getValue());
                    spellClass.setSpell(spell);
                    return spellClass;
                })
                .collect(Collectors.toSet());
    }

    private Set<SpellDomain> getSpellDomainFromRequest(SpellRequest request, Spell spell) {
        return request.domainLevels().entrySet().stream()
                .map(entry -> {
                    SpellDomain spellDomain = new SpellDomain();
                    Domain domain = domainRepository.findById(entry.getKey()).orElseThrow(DomainNotFoundException::new);
                    spellDomain.setDomain(domain);
                    spellDomain.setLevel(entry.getValue());
                    spellDomain.setSpell(spell);
                    return spellDomain;
                })
                .collect(Collectors.toSet());
    }

}
