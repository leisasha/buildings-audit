package dzhen.eren.controller.priv;

import dzhen.eren.model.measurementType.dto.MeasurementTypeOutDto;
import dzhen.eren.service.measurementType.MeasurementTypeService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private/measurementType")
@RequiredArgsConstructor
public class PrivateMeasurementTypeController {
    private final MeasurementTypeService measurementTypeService;

    @GetMapping("/{measurementTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public MeasurementTypeOutDto getById(@Positive @PathVariable Long measurementTypeId) {
        return measurementTypeService.getById(measurementTypeId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MeasurementTypeOutDto> getAll(
            @RequestParam(defaultValue = "0") int from,
            @RequestParam(defaultValue = "10") int size) {
        return measurementTypeService.getAll(from, size);
    }
}
