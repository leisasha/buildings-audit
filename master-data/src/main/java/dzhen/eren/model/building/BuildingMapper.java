package dzhen.eren.model.building;

import dzhen.eren.model.address.Address;
import dzhen.eren.model.address.AddressMapper;
import dzhen.eren.model.address.dto.AddressInDto;
import dzhen.eren.model.building.dto.BuildingInDto;
import dzhen.eren.model.building.dto.BuildingOutDto;
import dzhen.eren.repository.AddressRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BuildingMapper {
    public static Building buildingInDtoToBuilding(Address address) {
        return Building.builder()
                .address(address)
                .build();
    }

    public static BuildingOutDto buildingToBuildingOutDto(Building building) {
        return BuildingOutDto.builder()
                .id(building.getId())
                .addressOutDto(AddressMapper.addressToAddressOutDto(building.getAddress()))
                .build();
    }
}
