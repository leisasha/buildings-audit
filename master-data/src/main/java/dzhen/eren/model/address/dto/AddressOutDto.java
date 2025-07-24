package dzhen.eren.model.address.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressOutDto {
    private Long id;

    private String country;
    private String city;
    private String street;
    private String house;
    private String apartment;
}
