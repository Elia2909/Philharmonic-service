package philharmonic.service.spring.controller;

import philharmonic.service.spring.dto.request.StageRequestDto;
import philharmonic.service.spring.dto.response.StageResponseDto;
import philharmonic.service.spring.model.Stage;
import philharmonic.service.spring.service.StageService;
import philharmonic.service.spring.service.mapper.StageMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stages")
public class StageController {
    private final StageService stageService;
    private final StageMapper stageMapper;

    public StageController(StageService StageService,
                                StageMapper StageMapper) {
        this.stageService = StageService;
        this.stageMapper = StageMapper;
    }

    @PostMapping
    public StageResponseDto add(@RequestBody @Valid StageRequestDto requestDto) {
        Stage Stage = stageService.add(stageMapper.mapToModel(requestDto));
        return stageMapper.mapToDto(Stage);
    }

    @GetMapping
    public List<StageResponseDto> getAll() {
        return stageService.getAll()
                .stream()
                .map(stageMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
