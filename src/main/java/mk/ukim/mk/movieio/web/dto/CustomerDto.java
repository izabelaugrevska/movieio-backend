package mk.ukim.mk.movieio.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import mk.ukim.mk.movieio.model.Gender;
import mk.ukim.mk.movieio.model.Genre;

import java.util.Date;
import java.util.List;

public class CustomerDto {

    private String firstName;

    private String lastName;

    private Gender gender;

    private Date birthDate;
    @NotNull
    private String email;
    @NotNull
    private String username;
    @NotNull
    private String password;

    private List<Integer> movieReviewsIds;

    private String genreId;

    public CustomerDto() {
    }

    public CustomerDto(String firstName, String lastName, Gender gender, Date birthDate, String email,
                       String username, String password, List<Integer> movieReviewsIds, String genreId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.username = username;
        this.password = password;
        this.movieReviewsIds = movieReviewsIds;
        this.genreId = genreId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getMovieReviewsIds() {
        return movieReviewsIds;
    }

    public void setMovieReviewsIds(List<Integer> movieReviewsIds) {
        this.movieReviewsIds = movieReviewsIds;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }
}
