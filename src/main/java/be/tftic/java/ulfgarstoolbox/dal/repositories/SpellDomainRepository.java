package be.tftic.java.ulfgarstoolbox.dal.repositories;

import be.tftic.java.ulfgarstoolbox.domain.entities.SpellDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellDomainRepository extends JpaRepository<SpellDomain, Integer>, JpaSpecificationExecutor<SpellDomain> {
}
