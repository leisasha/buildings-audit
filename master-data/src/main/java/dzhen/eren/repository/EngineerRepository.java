package dzhen.eren.repository;

import dzhen.eren.model.engineer.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineerRepository extends JpaRepository<Engineer, Long> {
}
