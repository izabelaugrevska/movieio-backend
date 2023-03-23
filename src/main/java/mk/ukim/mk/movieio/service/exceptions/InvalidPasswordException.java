package mk.ukim.mk.movieio.service.exceptions;

public class InvalidPasswordException extends RuntimeException{

    public InvalidPasswordException() {
        super("Invalid password exception");
    }
}
