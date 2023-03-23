package mk.ukim.mk.movieio.service.exceptions;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException() {
        super("Invalid email exception");
    }
}
