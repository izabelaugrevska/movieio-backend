package mk.ukim.mk.movieio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "reservation", schema = "public")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "rv_id")
    private Integer id;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "datum", nullable = false)
    private Date date;

    @Column(name = "vreme", nullable = false)
    private String time;

    @Column(name = "price", nullable = false)
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "US_ID_cust")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "p_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "MP_ID")
    private MovieProjection movieProjection;

    @ManyToOne
  //  @JoinColumns({@JoinColumn(name = "MT_ID"), @JoinColumn(name = "ST_number")})
    @JoinColumn(name = "seat_id")
    private Seat seat;

}
