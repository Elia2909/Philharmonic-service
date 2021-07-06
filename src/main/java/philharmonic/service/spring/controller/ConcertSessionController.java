package philharmonic.service.spring.controller;

import philharmonic.service.spring.dto.request.ConcertSessionRequestDto;
import philharmonic.service.spring.dto.response.ConcertSessionResponseDto;
import philharmonic.service.spring.model.ConcertSession;
import philharmonic.service.spring.service.ConcertSessionService;
import philharmonic.service.spring.service.mapper.ConcertSessionMapper;
import philharmonic.service.spring.util.DateTimePatternUtil;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/concert-sessions")
public class ConcertSessionController {
    public static final String DATE_PATTERN = DateTimePatternUtil.DATE_PATTERN;
    private final ConcertSessionService concertSessionService;
    private final ConcertSessionMapper concertSessionMapper;

    public ConcertSessionController(ConcertSessionService ConcertSessionService,
                                  ConcertSessionMapper ConcertSessionMapper) {
        this.concertSessionService = ConcertSessionService;
        this.concertSessionMapper = ConcertSessionMapper;
    }

    @PostMapping
    public ConcertSessionResponseDto add(@RequestBody @Valid ConcertSessionRequestDto requestDto) {
        ConcertSession ConcertSession = concertSessionMapper.mapToModel(requestDto);
        concertSessionService.add(ConcertSession);
        return concertSessionMapper.mapToDto(ConcertSession);
    }

    @GetMapping("/available")
    public List<ConcertSessionResponseDto> getAll(@RequestParam Long ConcertId,
                                                @RequestParam
                                                @DateTimeFormat(pattern = DATE_PATTERN)
                                                        LocalDate date) {
        return concertSessionService.findAvailableSessions(ConcertId, date)
                .stream()
                .map(concertSessionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public ConcertSessionResponseDto update(@PathVariable Long id,
                                          @RequestBody @Valid ConcertSessionRequestDto requestDto) {
        ConcertSession ConcertSession = concertSessionMapper.mapToModel(requestDto);
        ConcertSession.setId(id);
        concertSessionService.update(ConcertSession);
        return concertSessionMapper.mapToDto(ConcertSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        concertSessionService.delete(id);
    }
}
