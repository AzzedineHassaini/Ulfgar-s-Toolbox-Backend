package be.azz.java.ulfgarstoolbox.dal.repositories;

import be.azz.java.ulfgarstoolbox.domain.entities.CharacterClass;
import be.azz.java.ulfgarstoolbox.domain.entities.SpellClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpellClassRepository extends JpaRepository<SpellClass, Integer> {

    @Query("SELECT sc FROM SpellClass sc WHERE sc.characterClass = :characterClass AND sc.level = :level")
    Optional<SpellClass> findByClassLevel(CharacterClass characterClass, Integer level);

}
