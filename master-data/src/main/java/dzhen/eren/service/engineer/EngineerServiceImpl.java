package dzhen.eren.service.engineer;

import dzhen.eren.exception.NotFoundException;
import dzhen.eren.model.engineer.Engineer;
import dzhen.eren.model.engineer.EngineerMapper;
import dzhen.eren.model.engineer.dto.EngineerInDto;
import dzhen.eren.model.engineer.dto.EngineerNewDto;
import dzhen.eren.model.engineer.dto.EngineerOutDto;
import dzhen.eren.repository.EngineerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EngineerServiceImpl implements EngineerService {
    private final EngineerRepository engineerRepository;

    public EngineerOutDto createEngineer(EngineerNewDto engineerNewDto) {
        return EngineerMapper.engineerToEngineerOutDto(
                engineerRepository.save(EngineerMapper.engineerNewDtoToEngineer(engineerNewDto))
        );
    }

    public EngineerOutDto updateEngineer(Long id, EngineerInDto engineerInDto) {
        Engineer engineer = engineerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Engineer not found"));

        engineer.setFirstName(engineerInDto.getFirstName());
        engineer.setLastName(engineerInDto.getLastName());
        engineer.setEmail(engineerInDto.getEmail());
        engineer.setJobTitle(engineerInDto.getJobTitle());

        return EngineerMapper.engineerToEngineerOutDto(engineerRepository.save(engineer));
    }

    public void deleteEngineer(Long id) {
        engineerRepository.deleteById(id);
    }

    public EngineerOutDto getById(Long engineerId) {
        Engineer engineer = engineerRepository.findById(engineerId)
                .orElseThrow(() -> new NotFoundException("Engineer not found"));

        return EngineerMapper.engineerToEngineerOutDto(engineer);
    }

    public List<EngineerOutDto> getEngineers(int from, int size) {
        Pageable pageable = PageRequest.of(from / size, size, Sort.by("id").ascending());
        Page<Engineer> page = engineerRepository.findAll(pageable);

        return page.getContent().stream()
                .map(EngineerMapper::engineerToEngineerOutDto)
                .collect(Collectors.toList());
    }
}
