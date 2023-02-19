package rodriguez.garcia.vanessa.calculator.handler;

import java.text.MessageFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.test.generated.api.dto.ErrorDto;

@ControllerAdvice
public class CalculatorExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handle(final IllegalArgumentException e, final HttpServletRequest request,
			final HttpServletResponse response) {
		
		final ErrorDto errorDto = new ErrorDto()
				.code(400)
				.message(MessageFormat.format("Operation {0} not allowed", e.getMessage()));
		
		return ResponseEntity.badRequest().body(errorDto);
	}
}
