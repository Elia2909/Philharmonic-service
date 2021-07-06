package philharmonic.service.spring.service.mapper;

import philharmonic.service.spring.dto.request.ConcertRequestDto;
import philharmonic.service.spring.dto.response.ConcertResponseDto;
import philharmonic.service.spring.model.Concert;
import org.springframework.stereotype.Component;

@Component
public class ConcertMapper implements RequestDtoMapper<ConcertRequestDto, Concert>,
        ResponseDtoMapper<ConcertResponseDto, Concert> {
    @Override
    public Concert mapToModel(ConcertRequestDto dto) {
        Concert concert = new Concert();
        concert.setTitle(dto.getConcertTitle());
        concert.setDescription(dto.getConcertDescription());
        return concert;
    }

    @Override
    public ConcertResponseDto mapToDto(Concert Concert) {
        ConcertResponseDto responseDto = new ConcertResponseDto();
        responseDto.setConcertId(Concert.getId());
        responseDto.setConcertTitle(Concert.getTitle());
        responseDto.setConcertDescription(Concert.getDescription());
        return responseDto;
    }
}
