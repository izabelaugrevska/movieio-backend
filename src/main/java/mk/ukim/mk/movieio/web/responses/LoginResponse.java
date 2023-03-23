package mk.ukim.mk.movieio.web.responses;

public class LoginResponse {
    private String message;
    private boolean success;

    private Integer id;

    public LoginResponse(boolean success, String message, Integer id) {
        this.success = success;
        this.message = message;
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}