package mk.ukim.mk.movieio.web.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SeatDto {

    @NotNull
    private Integer seatNumber;

    @NotNull
    private Integer movieTheaterId;

    @NotNull
    private Float seatPoints;
}
