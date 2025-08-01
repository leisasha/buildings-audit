package dzhen.eren.service.unit;

import dzhen.eren.model.unit.dto.UnitInDto;
import dzhen.eren.model.unit.dto.UnitOutDto;

import java.util.List;

public interface UnitService {
    UnitOutDto create(UnitInDto unitInDto);

    UnitOutDto update(Long id, UnitInDto unitInDto);

    void delete(Long id);

    UnitOutDto getById(Long id);

    List<UnitOutDto> getAll(int from, int size);
}
