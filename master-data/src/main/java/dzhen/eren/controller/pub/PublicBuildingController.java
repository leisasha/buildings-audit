package dzhen.eren.controller.pub;

import dzhen.eren.model.address.dto.AddressOutDto;
import dzhen.eren.model.building.dto.BuildingOutDto;
import dzhen.eren.service.address.AddressService;
import dzhen.eren.service.building.BuildingService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/building")
@RequiredArgsConstructor
public class PublicBuildingController {
    private final BuildingService buildingService;

    @GetMapping("/{buildingId}")
    @ResponseStatus(HttpStatus.OK)
    public BuildingOutDto getById(@Positive @PathVariable Long buildingId) {
        return buildingService.getById(buildingId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BuildingOutDto> getAll(
            @RequestParam(defaultValue = "0") int from,
            @RequestParam(defaultValue = "10") int size) {
        return buildingService.getAll(from, size);
    }
}
