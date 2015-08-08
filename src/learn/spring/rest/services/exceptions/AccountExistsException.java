package learn.spring.rest.services.exceptions;

public class AccountExistsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2300646334004666176L;

	public AccountExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountExistsException(String message) {
        super(message);
    }

    public AccountExistsException() {
        super();
    }
}
