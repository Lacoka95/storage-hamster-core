package hu.storagehamster.www.controller.exception;

import hu.storagehamster.www.Exception.ShelfOutOfCapacityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice {
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String fileNotFoundException() {
		log.debug("404");
		return "error/404";
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String internalServerError() {
		return "error/500";
	}

	@ExceptionHandler(ShelfOutOfCapacityException.class)
	public String internalServerError(ShelfOutOfCapacityException ex) {

		return "error/shelf-out-of-capacity";
	}
}
