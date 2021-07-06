package philharmonic.service.spring.dto.response;

public class ConcertSessionResponseDto {
    private Long ConcertSessionId;
    private Long ConcertId;
    private String ConcertTitle;
    private Long StageId;
    private String showTime;

    public Long getConcertSessionId() {
        return ConcertSessionId;
    }

    public void setConcertSessionId(Long ConcertSessionId) {
        this.ConcertSessionId = ConcertSessionId;
    }

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

    public Long getStageId() {
        return StageId;
    }

    public void setStageId(Long StageId) {
        this.StageId = StageId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
