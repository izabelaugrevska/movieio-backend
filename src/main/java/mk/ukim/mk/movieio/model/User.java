package mk.ukim.mk.movieio.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user_table", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "US_ID")
    private Integer id;

    @Column(name = "f_name", nullable = false)
    private String firstName;

    @Column(name = "l_name", nullable = false)
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonBackReference
//    private List<MovieReview> reviews;

    public User() {
    }

    @JsonCreator
    public  User(@JsonProperty("id") Integer id, @JsonProperty("username") String username, @JsonProperty("email") String email,
                 @JsonProperty("password") String password)
                 //@JsonProperty("reviews") List<MovieReview> reviews)
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        //this.reviews = reviews;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    //public List<MovieReview> getReviews() {
//        return reviews;
//    }

//    public void setReviews(List<MovieReview> reviews) {
//        this.reviews = reviews;
//    }

}
