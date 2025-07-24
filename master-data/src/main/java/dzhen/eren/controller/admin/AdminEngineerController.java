package dzhen.eren.controller.admin;

import dzhen.eren.model.engineer.dto.EngineerInDto;
import dzhen.eren.model.engineer.dto.EngineerNewDto;
import dzhen.eren.model.engineer.dto.EngineerOutDto;
import dzhen.eren.service.engineer.EngineerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/engineer")
@RequiredArgsConstructor
public class AdminEngineerController {
    private final EngineerService engineerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EngineerOutDto create(@Valid @RequestBody EngineerNewDto engineerNewDto) {
        return engineerService.create(engineerNewDto);
    }

    @PatchMapping("/{engineerId}")
    @ResponseStatus(HttpStatus.OK)
    public EngineerOutDto update(@Positive @PathVariable Long engineerId, @Valid @RequestBody EngineerInDto engineerInDto) {
        return engineerService.update(engineerId, engineerInDto);
    }

    @DeleteMapping("/{engineerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Positive @PathVariable Long engineerId) {
        engineerService.delete(engineerId);
    }
}
