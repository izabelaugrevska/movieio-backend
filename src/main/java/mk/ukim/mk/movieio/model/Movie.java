package mk.ukim.mk.movieio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Table(name = "movie", schema = "public")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "M_ID")
    private Integer id;

    @Column(name = "M_name", nullable = false)
    private String movieName;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "movie_length")
    private Integer movieLength;

    @Column(name = "m_points")
    private Integer moviePoints;

    @Column(name = "coverUrl")
    private String coverUrl;

    @ManyToMany
    @Column(name = "genre")
    private List<Genre> genre = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<MovieReview> reviews = new ArrayList<>();


    @OneToMany(mappedBy = "movie")
    private List<MovieProjection> projections = new ArrayList<>();

    @JsonManagedReference
    public List<MovieProjection> getProjections() {
        return projections;
    }
}
