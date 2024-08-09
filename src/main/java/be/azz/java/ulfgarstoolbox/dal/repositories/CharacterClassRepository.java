package be.azz.java.ulfgarstoolbox.dal.repositories;

import be.azz.java.ulfgarstoolbox.domain.entities.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterClassRepository extends JpaRepository<CharacterClass, Integer> {

    @Query("SELECT c FROM CharacterClass c WHERE c.name = :className")
    Optional<CharacterClass> findByClassName(String className);

    @Query("SELECT c FROM CharacterClass c WHERE c.magicType != null OR c.magicType != ''")
    List<CharacterClass> findAllSpellCastingClasses();

}
