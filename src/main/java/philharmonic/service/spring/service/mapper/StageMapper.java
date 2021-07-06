package philharmonic.service.spring.service.mapper;

import philharmonic.service.spring.dto.request.StageRequestDto;
import philharmonic.service.spring.dto.response.StageResponseDto;
import philharmonic.service.spring.model.Stage;
import org.springframework.stereotype.Component;

@Component
public class StageMapper implements RequestDtoMapper<StageRequestDto, Stage>,
        ResponseDtoMapper<StageResponseDto, Stage> {
    @Override
    public Stage mapToModel(StageRequestDto dto) {
        Stage stage = new Stage();
        stage.setDescription(dto.getDescription());
        stage.setCapacity(dto.getCapacity());
        return stage;
    }

    @Override
    public StageResponseDto mapToDto(Stage Stage) {
        StageResponseDto responseDto = new StageResponseDto();
        responseDto.setId(Stage.getId());
        responseDto.setDescription(Stage.getDescription());
        return responseDto;
    }
}
