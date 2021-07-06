package philharmonic.service.spring.service.mapper;

import org.springframework.stereotype.Component;
import philharmonic.service.spring.dto.request.ConcertRequestDto;
import philharmonic.service.spring.dto.response.ConcertResponseDto;
import philharmonic.service.spring.model.Concert;

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
    public ConcertResponseDto mapToDto(Concert concert) {
        ConcertResponseDto responseDto = new ConcertResponseDto();
        responseDto.setConcertId(concert.getId());
        responseDto.setConcertTitle(concert.getTitle());
        responseDto.setConcertDescription(concert.getDescription());
        return responseDto;
    }
}
