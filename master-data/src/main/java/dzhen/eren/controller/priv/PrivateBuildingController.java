package dzhen.eren.controller.priv;

import dzhen.eren.model.building.dto.BuildingInDto;
import dzhen.eren.model.building.dto.BuildingOutDto;
import dzhen.eren.service.building.BuildingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/private/building")
@RequiredArgsConstructor
public class PrivateBuildingController {
    private final BuildingService buildingService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BuildingOutDto create(@Valid @RequestBody BuildingInDto buildingInDto) {
        return buildingService.create(buildingInDto);
    }

    @PatchMapping("/{buildingId}")
    @ResponseStatus(HttpStatus.OK)
    public BuildingOutDto update(@Positive @PathVariable Long buildingId, @Valid @RequestBody BuildingInDto buildingInDto) {
        return buildingService.update(buildingId, buildingInDto);
    }

    @DeleteMapping("/{buildingId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable Long buildingId) {
        buildingService.delete(buildingId);
    }
}
