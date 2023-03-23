package mk.ukim.mk.movieio.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(name = "movie_projection", schema = "public")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class MovieProjection {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MP_ID")
    private Integer id;

    @Column(name = "projection_date", nullable = false)
    private Date projectionDate;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "projection_time", nullable = false)
    private String projectionTime;

    @ManyToOne
    @JoinColumn(name = "M_ID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "MT_ID")
    private MovieTheater movieTheater;

    @JsonBackReference
    public Movie getMovie() {
        return movie;
    }
}
