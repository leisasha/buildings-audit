package dzhen.eren.service.measurementType;

import dzhen.eren.model.measurementType.dto.MeasurementTypeInDto;
import dzhen.eren.model.measurementType.dto.MeasurementTypeOutDto;

import java.util.List;

public interface MeasurementTypeService {
    MeasurementTypeOutDto create(MeasurementTypeInDto measurementTypeInDto);

    MeasurementTypeOutDto update(Long id, MeasurementTypeInDto measurementTypeInDto);

    void delete(Long id);

    MeasurementTypeOutDto getById(Long id);

    List<MeasurementTypeOutDto> getAll(int from, int size);
}
