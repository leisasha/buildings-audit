package dzhen.eren.model.unit.dto;

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
public class UnitInDto {
    @NotBlank(message = "Поле name обязательно для заполнения")
    @Size(min = 1, max = 100)
    private String name;
}
