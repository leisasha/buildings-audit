package dzhen.eren.controller.admin;

import dzhen.eren.model.measurementType.dto.MeasurementTypeInDto;
import dzhen.eren.model.measurementType.dto.MeasurementTypeOutDto;
import dzhen.eren.service.measurementType.MeasurementTypeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/measurementType")
@RequiredArgsConstructor
public class AdminMeasurementTypeController {
    private final MeasurementTypeService measurementTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MeasurementTypeOutDto create(@Valid @RequestBody MeasurementTypeInDto measurementTypeInDto) {
        return measurementTypeService.create(measurementTypeInDto);
    }

    @PatchMapping("/{measurementTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public MeasurementTypeOutDto update(@Positive @PathVariable Long measurementTypeId,
                                        @Valid @RequestBody MeasurementTypeInDto measurementTypeInDto) {
        return measurementTypeService.update(measurementTypeId, measurementTypeInDto);
    }

    @DeleteMapping("/{measurementTypeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable Long measurementTypeId) {
        measurementTypeService.delete(measurementTypeId);
    }
}
