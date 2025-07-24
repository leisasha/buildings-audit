package dzhen.eren.model.engineer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EngineerInDto {
    @NotBlank(message = "Поле firstName обязательно для заполнения")
    @Size(min = 1, max = 100)
    private String firstName;

    @NotBlank(message = "Поле lastName обязательно для заполнения")
    @Size(min = 1, max = 100)
    private String lastName;

    @NotBlank(message = "Поле email обязательно для заполнения")
    @Size(min = 1, max = 100)
    private String email;

    @NotBlank(message = "Поле jobTitle обязательно для заполнения")
    @Size(min = 1, max = 100)
    private String jobTitle;
}
