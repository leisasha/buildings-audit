package dzhen.eren.model.building.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuildingInDto {
    @NotNull
    @Positive
    private Long addressId;
}
