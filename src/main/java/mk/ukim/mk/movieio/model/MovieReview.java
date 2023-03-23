package mk.ukim.mk.movieio.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "m_review", schema = "public")
public class MovieReview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "mrw_id")
    private Integer id;

    @Column(name = "m_review_date", nullable = false)
    private LocalDate reviewDate;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "description", length = 500)
    private String description;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "us_id")
    private Customer customer;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "M_ID")
    private Movie movie;

    @JsonCreator
    public MovieReview() {
    }
    @JsonCreator
    public MovieReview(@JsonProperty("description") String description,
                       @JsonProperty("rating") int rating,
                       @JsonProperty("date") LocalDate reviewDate,
                       @JsonProperty("movie") Movie movie,
                       @JsonProperty("user") Customer customer) {
        this.description = description;
        this.rating = rating;
        if(reviewDate != null) {
            this.reviewDate = reviewDate;
        }else{
            this.reviewDate = LocalDate.now();
        }
        this.movie = movie;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
