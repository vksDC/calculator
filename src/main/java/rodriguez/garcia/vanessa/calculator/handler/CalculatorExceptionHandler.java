package rodriguez.garcia.vanessa.calculator.handler;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.corp.calculator.TracerImpl;
import rodriguez.garcia.vanessa.calculator.constants.ErrorConstants;
import rodriguez.garcia.vanessa.calculator.exception.OperationNotSupportedException;

@ControllerAdvice
public class CalculatorExceptionHandler {

	private static final TracerImpl TRACER = new TracerImpl();
	
	@ExceptionHandler(OperationNotSupportedException.class)
	public ResponseEntity<Object> handle(final OperationNotSupportedException e, final HttpServletRequest request,
			final HttpServletResponse response) {
		TRACER.trace(MessageFormat.format("[CalculatorExceptionHandler] handle OperationNotSupportedException: {0}", e.getMessage()));
		
		return ResponseEntity.badRequest().body(ErrorConstants.OPERATION_NOT_SUPPORTED);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handle(final IllegalArgumentException e, final HttpServletRequest request,
			final HttpServletResponse response) {
		TRACER.trace("[CalculatorExceptionHandler] handle IllegalArgumentException");
		
		return ResponseEntity.badRequest().body(ErrorConstants.REQUIRED_OPERATORS);
	}
}
