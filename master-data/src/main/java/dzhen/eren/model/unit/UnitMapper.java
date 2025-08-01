package dzhen.eren.model.unit;

import dzhen.eren.model.unit.dto.UnitInDto;
import dzhen.eren.model.unit.dto.UnitOutDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UnitMapper {
    public static Unit unitInDtoToUnit(UnitInDto unitInDto) {
        return Unit.builder().name(unitInDto.getName()).build();
    }

    public static UnitOutDto unitToUnitOutDto(Unit unit) {
        return new UnitOutDto(
                unit.getId(),
                unit.getName());
    }
}
