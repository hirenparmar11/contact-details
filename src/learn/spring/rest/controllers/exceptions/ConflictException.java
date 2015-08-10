package learn.spring.rest.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1289917539300543004L;

	public ConflictException() {
    }

    public ConflictException(Throwable cause) {
        super(cause);
    }
}
