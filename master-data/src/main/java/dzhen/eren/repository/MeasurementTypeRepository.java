package dzhen.eren.repository;

import dzhen.eren.model.measurementType.MeasurementType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementTypeRepository extends JpaRepository<MeasurementType, Long> {
}
