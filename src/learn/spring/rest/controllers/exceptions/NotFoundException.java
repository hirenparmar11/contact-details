package learn.spring.rest.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4242034734620159030L;

	public NotFoundException() {
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
