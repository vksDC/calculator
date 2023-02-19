package rodriguez.garcia.vanessa.calculator.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import rodriguez.garcia.vanessa.calculator.constants.ErrorConstants;

@ControllerAdvice
public class CalculatorExceptionHandler {

	@ExceptionHandler(UnsupportedOperationException.class)
	public ResponseEntity<Object> handle(final UnsupportedOperationException e, final HttpServletRequest request,
			final HttpServletResponse response) {
		
		return ResponseEntity.badRequest().body(ErrorConstants.OPERATION_NOT_SUPPORTED);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handle(final IllegalArgumentException e, final HttpServletRequest request,
			final HttpServletResponse response) {
		
		return ResponseEntity.badRequest().body(ErrorConstants.REQUIRED_OPERATORS);
	}
}
