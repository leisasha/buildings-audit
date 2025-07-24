package dzhen.eren.model.address;

import dzhen.eren.model.address.dto.AddressInDto;
import dzhen.eren.model.address.dto.AddressNewDto;
import dzhen.eren.model.address.dto.AddressOutDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressMapper {
    public static Address addressNewDtoToAddress(AddressNewDto addressNewDto) {
        return Address.builder()
                .country(addressNewDto.getCountry())
                .city(addressNewDto.getCity())
                .street(addressNewDto.getStreet())
                .house(addressNewDto.getHouse())
                .apartment(addressNewDto.getApartment())
                .build();
    }

    public static Address addressInDtoToAddress(AddressInDto addressInDto) {
        return Address.builder()
                .country(addressInDto.getCountry())
                .city(addressInDto.getCity())
                .street(addressInDto.getStreet())
                .house(addressInDto.getHouse())
                .apartment(addressInDto.getApartment())
                .build();
    }

    public static AddressOutDto addressToAddressOutDto(Address address) {
        return new AddressOutDto(
                address.getId(),
                address.getCountry(),
                address.getCity(),
                address.getStreet(),
                address.getHouse(),
                address.getApartment());
    }
}
