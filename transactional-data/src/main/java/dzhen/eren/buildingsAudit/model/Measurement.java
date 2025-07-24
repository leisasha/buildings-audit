package dzhen.eren.buildingsAudit.model;

import dzhen.eren.model.building.Building;
import dzhen.eren.model.engineer.Engineer;
import dzhen.eren.model.measurementType.MeasurementType;
import dzhen.eren.model.unit.Unit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "measurements")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime measurementDate;
    private String parameterStringValue;
    private double parameterDoubleValue;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "measurement_type_id")
    private MeasurementType measurementType;

    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;

    @ManyToOne
    @JoinColumn(name = "engineer_id")
    private Engineer engineer;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
}
