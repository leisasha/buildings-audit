package dzhen.eren.service.building;

import dzhen.eren.exception.NotFoundException;
import dzhen.eren.model.address.Address;
import dzhen.eren.model.building.Building;
import dzhen.eren.model.building.BuildingMapper;
import dzhen.eren.model.building.dto.BuildingInDto;
import dzhen.eren.model.building.dto.BuildingOutDto;
import dzhen.eren.repository.AddressRepository;
import dzhen.eren.repository.BuildingRepository;
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
public class BuildingServiceImpl implements BuildingService {
    private final BuildingRepository buildingRepository;
    private final AddressRepository addressRepository;

    public BuildingOutDto create(BuildingInDto buildingInDto) {
        Address address = addressRepository.findById(buildingInDto.getAddressId())
                .orElseThrow(() -> new NotFoundException("Address not found"));

        return BuildingMapper.buildingToBuildingOutDto(
                buildingRepository.save(BuildingMapper.buildingInDtoToBuilding(address))
        );
    }

    public BuildingOutDto update(Long id, BuildingInDto buildingInDto) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Building not found"));

        Address address = addressRepository.findById(buildingInDto.getAddressId())
                .orElseThrow(() -> new NotFoundException("Address not found"));

        building.setAddress(address);

        return BuildingMapper.buildingToBuildingOutDto(buildingRepository.save(building));
    }

    public void delete(Long id) {
        buildingRepository.deleteById(id);
    }

    public BuildingOutDto getById(Long id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Building not found"));

        return BuildingMapper.buildingToBuildingOutDto(building);
    }

    public List<BuildingOutDto> getAll(int from, int size) {
        Pageable pageable = PageRequest.of(from / size, size, Sort.by("id").ascending());
        Page<Building> page = buildingRepository.findAll(pageable);

        return page.getContent().stream()
                .map(BuildingMapper::buildingToBuildingOutDto)
                .collect(Collectors.toList());
    }
}
