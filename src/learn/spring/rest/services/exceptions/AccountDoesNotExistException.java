package learn.spring.rest.services.exceptions;

public class AccountDoesNotExistException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7643196069115625743L;

	public AccountDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public AccountDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountDoesNotExistException(String message) {
        super(message);
    }

    public AccountDoesNotExistException() {
    }
}
