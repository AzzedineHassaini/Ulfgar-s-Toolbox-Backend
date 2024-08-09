package be.azz.java.ulfgarstoolbox.dal.repositories;

import be.azz.java.ulfgarstoolbox.domain.entities.views.SpellHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellHistoryRepository extends JpaRepository<SpellHistory, Integer>, JpaSpecificationExecutor<SpellHistory> {
}
