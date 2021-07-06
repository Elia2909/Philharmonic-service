package philharmonic.service.spring.dto.response;

public class ConcertResponseDto {
    private Long ConcertId;
    private String ConcertTitle;
    private String ConcertDescription;

    public Long getConcertId() {
        return ConcertId;
    }

    public void setConcertId(Long ConcertId) {
        this.ConcertId = ConcertId;
    }

    public String getConcertTitle() {
        return ConcertTitle;
    }

    public void setConcertTitle(String ConcertTitle) {
        this.ConcertTitle = ConcertTitle;
    }

    public String getConcertDescription() {
        return ConcertDescription;
    }

    public void setConcertDescription(String ConcertDescription) {
        this.ConcertDescription = ConcertDescription;
    }
}
