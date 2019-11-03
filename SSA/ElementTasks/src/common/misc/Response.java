package common.misc;

/**
 * Response which returns by validators after validation.
 */
public class Response {

    private boolean isValid;
    private String message;

    public Response(boolean isValid) {
        this.isValid = isValid;
        this.message = "";
    }

    public Response(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public boolean isValid() {
        return isValid;
    }

    public String getMessage() {
        return message;
    }
}
