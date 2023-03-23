package mk.ukim.mk.movieio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "s_review", schema = "public")
public class SeatReview {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "srw_id")
    private Integer id;

    @Column(name = "s_rating", nullable = false)
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "US_ID")
    private Customer customer;

    @ManyToOne
   // @JoinColumns({@JoinColumn(name = "MT_ID"), @JoinColumn(name = "ST_number")})
    @JoinColumn(name = "seat_id")
    private Seat seat;

    public SeatReview() {
    }

    public SeatReview(Integer id, Integer rating, Customer customer, Seat seat) {
        this.id = id;
        this.rating = rating;
        this.customer = customer;
        this.seat = seat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
