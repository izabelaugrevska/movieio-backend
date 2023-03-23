package mk.ukim.mk.movieio.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "employee", schema = "public")
@PrimaryKeyJoinColumn(name = "US_ID")
public class Employee extends User {

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "EMBG", nullable = false)
    private String embg;

    @Column(name = "phone_num")
    private Integer phoneNumber;

    @Column(name = "role")
    private String Role;

    @Column(name = "employment_time")
    private Integer employmentTime;

    @ManyToOne
    @JoinColumn(name = "US_ID_manager")
    private Employee manager;

}
