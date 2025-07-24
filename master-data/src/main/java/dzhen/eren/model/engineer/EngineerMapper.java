package dzhen.eren.model.engineer;

import dzhen.eren.model.engineer.dto.EngineerInDto;
import dzhen.eren.model.engineer.dto.EngineerNewDto;
import dzhen.eren.model.engineer.dto.EngineerOutDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EngineerMapper {
    public static Engineer engineerNewDtoToEngineer(EngineerNewDto engineerNewDto) {
        return Engineer.builder()
                .firstName(engineerNewDto.getFirstName())
                .lastName(engineerNewDto.getLastName())
                .email(engineerNewDto.getEmail())
                .jobTitle(engineerNewDto.getJobTitle())
                .build();
    }

    public static Engineer engineerInDtoToEngineer(EngineerInDto engineerInDto) {
        return Engineer.builder()
                .firstName(engineerInDto.getFirstName())
                .lastName(engineerInDto.getLastName())
                .email(engineerInDto.getEmail())
                .jobTitle(engineerInDto.getJobTitle())
                .build();
    }

    public static EngineerOutDto engineerToEngineerOutDto(Engineer engineer) {
        return new EngineerOutDto(
                engineer.getId(),
                engineer.getFirstName(),
                engineer.getLastName(),
                engineer.getEmail(),
                engineer.getJobTitle());
    }
}
