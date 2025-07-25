package dzhen.eren.model.engineer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EngineerOutDto {
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
}
