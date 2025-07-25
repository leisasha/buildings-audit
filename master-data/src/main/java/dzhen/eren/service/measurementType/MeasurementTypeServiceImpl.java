package dzhen.eren.service.measurementType;

import dzhen.eren.exception.NotFoundException;
import dzhen.eren.model.measurementType.MeasurementType;
import dzhen.eren.model.measurementType.MeasurementTypeMapper;
import dzhen.eren.model.measurementType.dto.MeasurementTypeInDto;
import dzhen.eren.model.measurementType.dto.MeasurementTypeOutDto;
import dzhen.eren.repository.MeasurementTypeRepository;
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
public class MeasurementTypeServiceImpl implements MeasurementTypeService {
    private final MeasurementTypeRepository measurementTypeRepository;

    public MeasurementTypeOutDto create(MeasurementTypeInDto measurementTypeInDto) {
        return MeasurementTypeMapper.measurementTypeToMeasurementTypeOutDto(
                measurementTypeRepository.save(MeasurementTypeMapper.measurementTypeInDtoToMeasurementType(measurementTypeInDto))
        );
    }

    public MeasurementTypeOutDto update(Long id, MeasurementTypeInDto measurementTypeInDto) {
        MeasurementType measurementType = measurementTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Measurement type not found"));

        measurementType.setName(measurementTypeInDto.getName());

        return MeasurementTypeMapper.measurementTypeToMeasurementTypeOutDto(measurementTypeRepository.save(measurementType));
    }

    public void delete(Long id) {
        measurementTypeRepository.deleteById(id);
    }

    public MeasurementTypeOutDto getById(Long id) {
        MeasurementType measurementType = measurementTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Measurement type not found"));

        return MeasurementTypeMapper.measurementTypeToMeasurementTypeOutDto(measurementType);
    }

    public List<MeasurementTypeOutDto> getAll(int from, int size) {
        Pageable pageable = PageRequest.of(from / size, size, Sort.by("id").ascending());
        Page<MeasurementType> page = measurementTypeRepository.findAll(pageable);

        return page.getContent().stream()
                .map(MeasurementTypeMapper::measurementTypeToMeasurementTypeOutDto)
                .collect(Collectors.toList());
    }
}
