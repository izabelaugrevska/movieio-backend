package mk.ukim.mk.movieio.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.mk.movieio.model.*;

import java.util.Date;

@Data
public class ReservationDto {

    @NotNull
    private Status status;

    @NotNull
    private Date date;

    @NotNull
    private String time;

    @NotNull
    private Integer price;

    @NotNull
    private Integer employeeId;

    @NotNull
    private Integer customerId;

    @NotNull
    private Integer movieProjectionId;

    @NotNull
    private Seat seat;

    @NotNull
    private Integer amount;

}
