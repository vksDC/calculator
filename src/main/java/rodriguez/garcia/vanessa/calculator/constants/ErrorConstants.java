package rodriguez.garcia.vanessa.calculator.constants;

import com.test.generated.api.dto.ErrorDto;

public class ErrorConstants {
	
	public static final ErrorDto OPERATION_NOT_SUPPORTED = new ErrorDto().code(100)
			.message("Operation not supported");

	public static final ErrorDto REQUIRED_OPERATORS = new ErrorDto().code(101)
			.message("The minimum number of operators required to perform the operation is 2");
}
