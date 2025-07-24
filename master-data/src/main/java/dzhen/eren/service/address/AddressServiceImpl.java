package dzhen.eren.service.address;

import dzhen.eren.exception.NotFoundException;
import dzhen.eren.model.address.Address;
import dzhen.eren.model.address.AddressMapper;
import dzhen.eren.model.address.dto.AddressInDto;
import dzhen.eren.model.address.dto.AddressNewDto;
import dzhen.eren.model.address.dto.AddressOutDto;
import dzhen.eren.repository.AddressRepository;
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
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressOutDto create(AddressNewDto addressNewDto) {
        return AddressMapper.addressToAddressOutDto(
                addressRepository.save(AddressMapper.addressNewDtoToAddress(addressNewDto))
        );
    }

    public AddressOutDto update(Long id, AddressInDto addressInDto) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Address not found"));

        address.setCountry(addressInDto.getCountry());
        address.setCity(addressInDto.getCity());
        address.setStreet(addressInDto.getStreet());
        address.setHouse(addressInDto.getHouse());
        address.setApartment(addressInDto.getApartment());

        return AddressMapper.addressToAddressOutDto(addressRepository.save(address));
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }

    public AddressOutDto getById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Address not found"));

        return AddressMapper.addressToAddressOutDto(address);
    }

    public List<AddressOutDto> getAll(int from, int size) {
        Pageable pageable = PageRequest.of(from / size, size, Sort.by("id").ascending());
        Page<Address> page = addressRepository.findAll(pageable);

        return page.getContent().stream()
                .map(AddressMapper::addressToAddressOutDto)
                .collect(Collectors.toList());
    }
}
