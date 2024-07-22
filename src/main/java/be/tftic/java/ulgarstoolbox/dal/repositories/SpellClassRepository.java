package be.tftic.java.ulgarstoolbox.dal.repositories;

import be.tftic.java.ulgarstoolbox.domain.entities.SpellClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellClassRepository extends JpaRepository<SpellClass, Integer>, JpaSpecificationExecutor<SpellClass> {

}
