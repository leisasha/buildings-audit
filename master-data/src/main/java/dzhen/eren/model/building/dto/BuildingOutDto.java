package dzhen.eren.model.building.dto;

import dzhen.eren.model.address.dto.AddressOutDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildingOutDto {
    private Long id;
    private AddressOutDto addressOutDto;
}
