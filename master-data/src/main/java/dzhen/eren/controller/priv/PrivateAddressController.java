package dzhen.eren.controller.priv;

import dzhen.eren.model.address.dto.AddressInDto;
import dzhen.eren.model.address.dto.AddressNewDto;
import dzhen.eren.model.address.dto.AddressOutDto;
import dzhen.eren.service.address.AddressService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private/address")
@RequiredArgsConstructor
public class PrivateAddressController {
    private final AddressService addressService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressOutDto create(@Valid @RequestBody AddressNewDto addressNewDto) {
        return addressService.create(addressNewDto);
    }

    @PatchMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public AddressOutDto update(@Positive @PathVariable Long addressId, @Valid @RequestBody AddressInDto addressInDto) {
        return addressService.update(addressId, addressInDto);
    }

    @DeleteMapping("/{addressId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable Long addressId) {
        addressService.delete(addressId);
    }
}
