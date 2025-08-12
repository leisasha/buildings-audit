package dzhen.eren.controller.admin;

import dzhen.eren.model.unit.dto.UnitInDto;
import dzhen.eren.model.unit.dto.UnitOutDto;
import dzhen.eren.service.unit.UnitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/unit")
@RequiredArgsConstructor
public class AdminUnitController {
    private final UnitService unitService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UnitOutDto create(@Valid @RequestBody UnitInDto unitInDto) {
        return unitService.create(unitInDto);
    }

    @PatchMapping("/{unitId}")
    @ResponseStatus(HttpStatus.OK)
    public UnitOutDto update(@Positive @PathVariable Long unitId, @Valid @RequestBody UnitInDto unitInDto) {
        return unitService.update(unitId, unitInDto);
    }

    @DeleteMapping("/{unitId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable Long unitId) {
        unitService.delete(unitId);
    }
}
