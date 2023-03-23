package mk.ukim.mk.movieio.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MovieTheaterDto {

    @NotNull
    private Integer capacity;

    @NotNull
    private String movieTheaterName;

}
