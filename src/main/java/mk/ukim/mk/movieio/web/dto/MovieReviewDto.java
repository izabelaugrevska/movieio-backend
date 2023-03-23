package mk.ukim.mk.movieio.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class MovieReviewDto {

    @NotNull
    private LocalDate reviewDate;

    @NotNull
    private Integer rating;

    @Size(max = 500)
    private String description;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer movieId;

    public MovieReviewDto() {}

    public MovieReviewDto(@JsonProperty("description")String description,
                             @JsonProperty("rating")int rating,@JsonProperty("reviewDate") LocalDate reviewDate,
                             @JsonProperty("movieId")Integer movieId, @JsonProperty("userId") Integer userId) {
        this.description = description;
        this.rating = rating;
        this.reviewDate = reviewDate;
        this.movieId = movieId;
        this.userId = userId;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}
