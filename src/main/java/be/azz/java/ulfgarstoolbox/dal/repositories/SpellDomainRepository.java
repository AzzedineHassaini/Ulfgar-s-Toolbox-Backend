package be.azz.java.ulfgarstoolbox.dal.repositories;

import be.azz.java.ulfgarstoolbox.domain.entities.Domain;
import be.azz.java.ulfgarstoolbox.domain.entities.SpellDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpellDomainRepository extends JpaRepository<SpellDomain, Integer> {

    @Query("SELECT sd FROM SpellDomain sd WHERE sd.domain = :domain AND sd.level = :level")
    Optional<SpellDomain> findByDomainLevel(Domain domain, Integer level);

}
