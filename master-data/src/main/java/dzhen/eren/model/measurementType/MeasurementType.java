package dzhen.eren.model.measurementType;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "measurement_type")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeasurementType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
