package learn.spring.rest.services.exceptions;

public class BlogExistsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 6112920387935461847L;

	public BlogExistsException() {
    }

    public BlogExistsException(String message) {
        super(message);
    }

    public BlogExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogExistsException(Throwable cause) {
        super(cause);
    }
}
