package mk.ukim.mk.movieio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "movie_theater", schema = "public")
public class MovieTheater {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MT_ID")
    private Integer id;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "MT_name", nullable = false)
    private String movieTheaterName;

    // @OneToMany(mappedBy = "movieTheater")
    // private List<MovieProjection> projections = new ArrayList<>();

}
