package be.azz.java.ulfgarstoolbox.dal.repositories;

import be.azz.java.ulfgarstoolbox.domain.entities.BonusSpell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BonusSpellRepository extends JpaRepository<BonusSpell, Integer> {

    @Query("SELECT b from BonusSpell b WHERE b.abilityScore = :abilityScore")
    Optional<BonusSpell> findByAbilityScore(Integer abilityScore);

    @Query("SELECT b from BonusSpell b WHERE b.modifier = :modifier")
    Optional<BonusSpell> findByModifier(Integer modifier);
}
