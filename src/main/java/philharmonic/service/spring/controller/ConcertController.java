package philharmonic.service.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import philharmonic.service.spring.dto.request.ConcertRequestDto;
import philharmonic.service.spring.dto.response.ConcertResponseDto;
import philharmonic.service.spring.model.Concert;
import philharmonic.service.spring.service.ConcertService;
import philharmonic.service.spring.service.mapper.ConcertMapper;

@RestController
@RequestMapping("/concerts")
public class ConcertController {
    private final ConcertService concertService;
    private final ConcertMapper concertMapper;

    public ConcertController(ConcertService concertService, ConcertMapper concertMapper) {
        this.concertService = concertService;
        this.concertMapper = concertMapper;
    }

    @PostMapping
    public ConcertResponseDto add(@RequestBody @Valid ConcertRequestDto requestDto) {
        Concert concert = concertService.add(concertMapper.mapToModel(requestDto));
        return concertMapper.mapToDto(concert);
    }

    @GetMapping
    public List<ConcertResponseDto> getAll() {
        return concertService.getAll()
                .stream()
                .map(concertMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
