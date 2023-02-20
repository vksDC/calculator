package rodriguez.garcia.vanessa.calculator.service;

import java.math.BigDecimal;
import java.util.List;

public interface SimpleOperationsApiService {

	/**
	 * Method that performs the indicated operation over the given list, said list must contain two
	 * operators at least, an {@link IllegalArgumentException} will be thrown
	 * otherwise.
	 * 
	 * @param operationCode The operation to execute.
	 * @param operators The arguments to sum.
	 * @return The result of the operation.
	 */
	BigDecimal calculate(final String operationCode, final List<BigDecimal> operators);
}
