package mk.ukim.mk.movieio.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.mk.movieio.model.Customer;

@Data
public class PaymentDto {
    @NotNull
    private Integer amount;

    @NotNull
    private Integer customerId;

    @NotNull
    private Integer movieProjectionId;

    @NotNull
    private Integer seatId;
}
