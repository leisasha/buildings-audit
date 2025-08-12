package dzhen.eren.controller.priv;

import dzhen.eren.model.unit.dto.UnitOutDto;
import dzhen.eren.service.unit.UnitService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private/unit")
@RequiredArgsConstructor
public class PrivateUnitController {
    private final UnitService unitService;

    @GetMapping("/{unitId}")
    @ResponseStatus(HttpStatus.OK)
    public UnitOutDto getById(@Positive @PathVariable Long unitId) {
        return unitService.getById(unitId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UnitOutDto> getAll(
            @RequestParam(defaultValue = "0") int from,
            @RequestParam(defaultValue = "10") int size) {
        return unitService.getAll(from, size);
    }
}
