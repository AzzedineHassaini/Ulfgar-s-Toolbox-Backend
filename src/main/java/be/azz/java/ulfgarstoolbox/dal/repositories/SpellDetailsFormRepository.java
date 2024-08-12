package be.azz.java.ulfgarstoolbox.dal.repositories;

import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellDetailsForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface SpellDetailsFormRepository extends JpaRepository<SpellDetailsForm, Integer>, JpaSpecificationExecutor<SpellDetailsForm> {

}
