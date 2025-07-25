package dzhen.eren.model.measurementType;

import dzhen.eren.model.measurementType.dto.MeasurementTypeInDto;
import dzhen.eren.model.measurementType.dto.MeasurementTypeOutDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MeasurementTypeMapper {
    public static MeasurementType measurementTypeInDtoToMeasurementType(MeasurementTypeInDto measurementTypeInDto) {
        return MeasurementType.builder().name(measurementTypeInDto.getName()).build();
    }

    public static MeasurementTypeOutDto measurementTypeToMeasurementTypeOutDto(MeasurementType measurementType) {
        return new MeasurementTypeOutDto(
                measurementType.getId(),
                measurementType.getName());
    }
}
