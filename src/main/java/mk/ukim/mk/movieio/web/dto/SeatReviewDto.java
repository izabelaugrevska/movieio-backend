package mk.ukim.mk.movieio.web.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.mk.movieio.model.Seat;
import mk.ukim.mk.movieio.model.User;

@Data
public class SeatReviewDto {

    @NotNull
    private Integer rating;

   @NotNull
    private Integer customerId;

    @NotNull
    private Integer seatId;

    public SeatReviewDto() {
    }

    public SeatReviewDto(Integer rating, Integer customerId, Integer seatId) {
        this.rating = rating;
        this.customerId = customerId;
        this.seatId = seatId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }
}
