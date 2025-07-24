package dzhen.eren.service.engineer;

import dzhen.eren.model.engineer.dto.EngineerInDto;
import dzhen.eren.model.engineer.dto.EngineerNewDto;
import dzhen.eren.model.engineer.dto.EngineerOutDto;

import java.util.List;

public interface EngineerService {
    EngineerOutDto createEngineer(EngineerNewDto engineerNewDto);

    EngineerOutDto updateEngineer(Long id, EngineerInDto engineerInDto);

    void deleteEngineer(Long id);

    EngineerOutDto getById(Long engineerId);

    List<EngineerOutDto> getEngineers(int from, int size);
}
