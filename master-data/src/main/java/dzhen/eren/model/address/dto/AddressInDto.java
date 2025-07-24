package dzhen.eren.model.address.dto;

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
public class AddressInDto {
    @NotBlank(message = "Поле country обязательно для заполнения")
    @Size(min = 1, max = 100)
    private String country;

    @NotBlank(message = "Поле city обязательно для заполнения")
    @Size(min = 1, max = 100)
    private String city;

    @NotBlank(message = "Поле street обязательно для заполнения")
    @Size(min = 1, max = 100)
    private String street;

    @NotBlank(message = "Поле house обязательно для заполнения")
    @Size(min = 1, max = 100)
    private String house;

    @NotBlank(message = "Поле apartment обязательно для заполнения")
    @Size(min = 1, max = 100)
    private String apartment;
}
