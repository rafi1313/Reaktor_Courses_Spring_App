package reaktor.reaktorapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reaktor.reaktorapp.model.entity.Edition;

public interface EditionRepository extends JpaRepository<Edition,Long> {
}
