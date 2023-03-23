package mk.ukim.mk.movieio.web.dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import mk.ukim.mk.movieio.model.Gender;

import java.util.Date;

public class EmployeeDto {

    private String firstName;

    private String lastName;

    private Gender gender;

    private Date birthDate;

    private String email;

    private String username;

    private String password;

    private Integer salary;

    private String embg;

    private Integer phoneNumber;

    private String Role;

    private Integer employmentTime;

    private Integer managerId;

    public EmployeeDto() {
    }

    public EmployeeDto(String firstName, String lastName, Gender gender, Date birthDate, String email,
                       String username, String password, Integer salary, String embg, Integer phoneNumber,
                       String role, Integer employmentTime, Integer managerId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.embg = embg;
        this.phoneNumber = phoneNumber;
        Role = role;
        this.employmentTime = employmentTime;
        this.managerId = managerId;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getEmbg() {
        return embg;
    }

    public void setEmbg(String embg) {
        this.embg = embg;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public Integer getEmploymentTime() {
        return employmentTime;
    }

    public void setEmploymentTime(Integer employmentTime) {
        this.employmentTime = employmentTime;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }
}
