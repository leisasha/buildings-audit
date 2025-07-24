package dzhen.eren.controller.priv;

import dzhen.eren.model.engineer.dto.EngineerOutDto;
import dzhen.eren.service.engineer.EngineerService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private/engineer")
@RequiredArgsConstructor
public class PrivateEngineerController {
    private final EngineerService engineerService;

    @GetMapping("/{engineerId}")
    @ResponseStatus(HttpStatus.OK)
    public EngineerOutDto getById(@Positive @PathVariable Long engineerId) {
        return engineerService.getById(engineerId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EngineerOutDto> getAll(
            @RequestParam(defaultValue = "0") int from,
            @RequestParam(defaultValue = "10") int size) {
        return engineerService.getAll(from, size);
    }
}
