package mk.ukim.mk.movieio.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class MovieProjectionDto {

    @NotNull
    private Date projectionDate;

    @NotNull
    private Integer price;

    @NotNull
    private String projectionTime;

    @NotNull
    private Integer movieId;

    @NotNull
    private Integer movieTheaterId;

    public MovieProjectionDto(@JsonProperty("projectionDate") Date projectionDate, @JsonProperty("price") int price,
                              @JsonProperty("projectionTime") String projectionTime, @JsonProperty("movieId") int movieId,
                              @JsonProperty("movieTheaterId") int movieTheaterId){
        this.projectionDate = projectionDate;
        this.price = price;
        this.projectionTime = projectionTime;
        this.movieId = movieId;
        this.movieTheaterId = movieTheaterId;
    }

}
