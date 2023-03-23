package mk.ukim.mk.movieio.service.exceptions;

public class InvalidCustomerCredentialsException extends RuntimeException{
    public InvalidCustomerCredentialsException() {
        super("Invalid credentials exception");
    }
}
