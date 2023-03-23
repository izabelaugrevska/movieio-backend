package mk.ukim.mk.movieio.service.exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException() {
        super("Email already exists");
    }
}
