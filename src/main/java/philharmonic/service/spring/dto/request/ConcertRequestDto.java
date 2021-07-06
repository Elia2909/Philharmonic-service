package philharmonic.service.spring.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConcertRequestDto {
    @NotNull
    private String ConcertTitle;
    @Size(max = 200)
    private String ConcertDescription;

    public String getConcertTitle() {
        return ConcertTitle;
    }

    public String getConcertDescription() {
        return ConcertDescription;
    }
}
