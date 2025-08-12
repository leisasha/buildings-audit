package dzhen.eren.service.building;

import dzhen.eren.model.building.dto.BuildingInDto;
import dzhen.eren.model.building.dto.BuildingOutDto;

import java.util.List;

public interface BuildingService {
    BuildingOutDto create(BuildingInDto buildingInDto);

    BuildingOutDto update(Long id, BuildingInDto buildingInDto);

    void delete(Long id);

    BuildingOutDto getById(Long id);

    List<BuildingOutDto> getAll(int from, int size);
}
