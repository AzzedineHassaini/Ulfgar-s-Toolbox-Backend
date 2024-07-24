package be.tftic.java.ulgarstoolbox.dal.repositories;

import be.tftic.java.ulgarstoolbox.domain.entities.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DomainRepository extends JpaRepository<Domain, Integer>, JpaSpecificationExecutor<Domain> {

    @Query("SELECT d from Domain d WHERE d.name = :domainName")
    Optional<Domain> findByDomainName(String domainName);

}
