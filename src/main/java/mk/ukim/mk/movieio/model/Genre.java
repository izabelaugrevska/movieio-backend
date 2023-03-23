package mk.ukim.mk.movieio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "genre", schema = "public")
public class Genre {

    @Id
    @Column(name = "g_name")
    private String genreName;

}
