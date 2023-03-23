package mk.ukim.mk.movieio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Optional;

@Data
@Entity
@Table(name = "payment", schema = "public")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "p_id")
    private Integer id;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "US_ID")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "movieProjectionId")
    private MovieProjection movieProjection;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

}
