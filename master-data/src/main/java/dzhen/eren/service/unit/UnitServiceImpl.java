package dzhen.eren.service.unit;

import dzhen.eren.exception.NotFoundException;
import dzhen.eren.model.unit.Unit;
import dzhen.eren.model.unit.UnitMapper;
import dzhen.eren.model.unit.dto.UnitInDto;
import dzhen.eren.model.unit.dto.UnitOutDto;
import dzhen.eren.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UnitServiceImpl implements UnitService {
    private final UnitRepository unitRepository;

    public UnitOutDto create(UnitInDto unitInDto) {
        return UnitMapper.unitToUnitOutDto(
                unitRepository.save(UnitMapper.unitInDtoToUnit(unitInDto))
        );
    }

    public UnitOutDto update(Long id, UnitInDto unitInDto) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Unit not found"));

        unit.setName(unitInDto.getName());

        return UnitMapper.unitToUnitOutDto(unitRepository.save(unit));
    }

    public void delete(Long id) {
        unitRepository.deleteById(id);
    }

    public UnitOutDto getById(Long id) {
        Unit unit = unitRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Unit not found"));

        return UnitMapper.unitToUnitOutDto(unit);
    }

    public List<UnitOutDto> getAll(int from, int size) {
        Pageable pageable = PageRequest.of(from / size, size, Sort.by("id").ascending());
        Page<Unit> page = unitRepository.findAll(pageable);

        return page.getContent().stream()
                .map(UnitMapper::unitToUnitOutDto)
                .collect(Collectors.toList());
    }
}
