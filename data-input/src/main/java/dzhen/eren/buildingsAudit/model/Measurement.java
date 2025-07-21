package dzhen.eren.buildingsAudit.model;

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
    private String measurementType;
    private String parameterName;
    private double parameterValue;
    private String unit;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "engineer_id")
    private Engineer engineer;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
}
