package be.azz.java.ulfgarstoolbox.dal.repositories;

import be.azz.java.ulfgarstoolbox.domain.entities.ClassLeveling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassLevelingRepository extends JpaRepository<ClassLeveling, Integer> {
}
