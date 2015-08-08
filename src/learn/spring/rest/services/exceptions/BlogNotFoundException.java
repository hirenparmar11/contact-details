package learn.spring.rest.services.exceptions;

public class BlogNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2955100038849182744L;

	public BlogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogNotFoundException(String message) {
        super(message);
    }

    public BlogNotFoundException() {
    }
}
