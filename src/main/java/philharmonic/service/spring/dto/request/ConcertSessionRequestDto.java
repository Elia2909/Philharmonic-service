package philharmonic.service.spring.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ConcertSessionRequestDto {
    @Positive
    private Long concertId;
    @Positive
    private Long stageId;
    @NotNull
    private String showTime;

    public Long getConcertId() {
        return concertId;
    }

    public Long getStageId() {
        return stageId;
    }

    public String getShowTime() {
        return showTime;
    }
}
