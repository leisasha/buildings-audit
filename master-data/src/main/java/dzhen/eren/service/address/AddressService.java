package dzhen.eren.service.address;

import dzhen.eren.model.address.dto.AddressInDto;
import dzhen.eren.model.address.dto.AddressNewDto;
import dzhen.eren.model.address.dto.AddressOutDto;

import java.util.List;

public interface AddressService {
    AddressOutDto create(AddressNewDto addressNewDto);

    AddressOutDto update(Long id, AddressInDto addressInDto);

    void delete(Long id);

    AddressOutDto getById(Long id);

    List<AddressOutDto> getAll(int from, int size);
}
