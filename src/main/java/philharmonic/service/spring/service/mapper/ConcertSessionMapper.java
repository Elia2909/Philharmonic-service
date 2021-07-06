package philharmonic.service.spring.service.mapper;

import philharmonic.service.spring.dto.request.ConcertSessionRequestDto;
import philharmonic.service.spring.dto.response.ConcertSessionResponseDto;
import philharmonic.service.spring.model.ConcertSession;
import philharmonic.service.spring.service.StageService;
import philharmonic.service.spring.service.ConcertService;
import philharmonic.service.spring.util.DateTimePatternUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ConcertSessionMapper implements RequestDtoMapper<ConcertSessionRequestDto, ConcertSession>,
        ResponseDtoMapper<ConcertSessionResponseDto, ConcertSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final StageService StageService;
    private final ConcertService ConcertService;

    public ConcertSessionMapper(StageService StageService, ConcertService ConcertService) {
        this.StageService = StageService;
        this.ConcertService = ConcertService;
    }

    @Override
    public ConcertSession mapToModel(ConcertSessionRequestDto dto) {
        ConcertSession concertSession = new ConcertSession();
        concertSession.setConcert(ConcertService.get(dto.getConcertId()));
        concertSession.setStage(StageService.get(dto.getStageId()));
        concertSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return concertSession;
    }

    @Override
    public ConcertSessionResponseDto mapToDto(ConcertSession ConcertSession) {
        ConcertSessionResponseDto responseDto = new ConcertSessionResponseDto();
        responseDto.setConcertSessionId(ConcertSession.getId());
        responseDto.setStageId(ConcertSession.getStage().getId());
        responseDto.setConcertId(ConcertSession.getConcert().getId());
        responseDto.setConcertTitle(ConcertSession.getConcert().getTitle());
        responseDto.setShowTime(ConcertSession.getShowTime().format(formatter));
        return responseDto;
    }
}
