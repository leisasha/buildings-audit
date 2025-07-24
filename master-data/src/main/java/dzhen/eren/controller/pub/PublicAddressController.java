package dzhen.eren.controller.pub;

import dzhen.eren.model.address.dto.AddressOutDto;
import dzhen.eren.service.address.AddressService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private/address")
@RequiredArgsConstructor
public class PublicAddressController {
    private final AddressService addressService;

    @GetMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public AddressOutDto getById(@Positive @PathVariable Long addressId) {
        return addressService.getById(addressId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AddressOutDto> getAll(
            @RequestParam(defaultValue = "0") int from,
            @RequestParam(defaultValue = "10") int size) {
        return addressService.getAll(from, size);
    }
}
