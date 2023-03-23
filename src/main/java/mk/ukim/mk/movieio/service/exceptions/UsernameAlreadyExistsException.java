package mk.ukim.mk.movieio.service.exceptions;

public class UsernameAlreadyExistsException extends RuntimeException{

    public UsernameAlreadyExistsException(){
        super("Username already exists");
    }
}
