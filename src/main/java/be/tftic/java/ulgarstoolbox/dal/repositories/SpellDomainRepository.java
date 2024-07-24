package be.tftic.java.ulgarstoolbox.dal.repositories;

import be.tftic.java.ulgarstoolbox.domain.entities.SpellDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellDomainRepository extends JpaRepository<SpellDomain, Integer>, JpaSpecificationExecutor<SpellDomain> {
}
