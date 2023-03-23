package mk.ukim.mk.movieio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "customer", schema = "public")
@PrimaryKeyJoinColumn(name = "US_ID")
public class Customer extends User {

    @Column(name = "fav_genre")
    private String favoriteGenre;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<MovieReview> reviews;

}
