package be.azz.java.ulfgarstoolbox.dal.repositories;

import be.azz.java.ulfgarstoolbox.domain.entities.tempTables.SpellDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpellRepository extends JpaRepository<SpellDetails, Long>, JpaSpecificationExecutor<SpellDetails> {

    @Query(value = "CALL GetSortDetails(:spellId)", nativeQuery = true)
    Optional<SpellDetails> getSpellDetails(@Param("spellId") Integer spellId);

    @Query(value = "CALL GetAllSortDetails()", nativeQuery = true)
    List<SpellDetails> getAllSpellDetails();

}
