package philharmonic.service.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class ConcertSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Concert Concert;
    @ManyToOne
    private Stage Stage;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Concert getConcert() {
        return Concert;
    }

    public void setConcert(Concert Concert) {
        this.Concert = Concert;
    }

    public Stage getStage() {
        return Stage;
    }

    public void setStage(Stage Stage) {
        this.Stage = Stage;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "ConcertSession{"
                + "id=" + id
                + ", Concert=" + Concert
                + ", Stage=" + Stage
                + ", showTime=" + showTime + '}';
    }
}
