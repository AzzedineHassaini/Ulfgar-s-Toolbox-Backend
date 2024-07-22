package be.tftic.java.ulgarstoolbox.dal.repositories;

import be.tftic.java.ulgarstoolbox.domain.entities.CharacterClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterClassRepository extends JpaRepository<CharacterClass, Integer>, JpaSpecificationExecutor<CharacterClass> {

    @Query("SELECT c from CharacterClass c WHERE c.name = :className")
    Optional<CharacterClass> findByClassName(String className);

}
