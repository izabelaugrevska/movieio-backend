package mk.ukim.mk.movieio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "seat", schema = "public")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "seat_id", nullable = false)
    private  Integer seatId;

    @Column(name = "ST_number", nullable = false)
    private Integer seatNumber;

    @Column(name="mt_id", nullable = false)
    private Integer movieTheaterId;

    @Column(name = "s_points", nullable = false)
    private Float seatPoints;

    @Column(name = "status")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
