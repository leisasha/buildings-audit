package dzhen.eren.service.engineer;

import dzhen.eren.model.engineer.dto.EngineerInDto;
import dzhen.eren.model.engineer.dto.EngineerNewDto;
import dzhen.eren.model.engineer.dto.EngineerOutDto;

import java.util.List;

public interface EngineerService {
    EngineerOutDto create(EngineerNewDto engineerNewDto);

    EngineerOutDto update(Long id, EngineerInDto engineerInDto);

    void delete(Long id);

    EngineerOutDto getById(Long id);

    List<EngineerOutDto> getAll(int from, int size);
}
