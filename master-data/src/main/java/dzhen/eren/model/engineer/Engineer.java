package dzhen.eren.model.engineer;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "engineers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
}
