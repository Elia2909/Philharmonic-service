package philharmonic.service.spring.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ConcertSessionRequestDto {
    @Positive
    private Long ConcertId;
    @Positive
    private Long StageId;
    @NotNull
    private String showTime;

    public Long getConcertId() {
        return ConcertId;
    }

    public Long getStageId() {
        return StageId;
    }

    public String getShowTime() {
        return showTime;
    }
}
