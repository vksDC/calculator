package rodriguez.garcia.vanessa.calculator.service;

import java.math.BigDecimal;
import java.util.List;

public interface SimpleOperationsApiService {

	/**
	 * Method that returns the sum of the given list, said list must contain two
	 * operators at least, an {@link IllegalArgumentException} will be thrown
	 * otherwise.
	 * 
	 * @param operators The arguments to sum.
	 * @return The result of the operation.
	 */
	BigDecimal add(final List<BigDecimal> operators);

	/**
	 * Method that returns the difference of the given list, said list must contain two
	 * operators at least, an {@link IllegalArgumentException} will be thrown
	 * otherwise.
	 * 
	 * @param operators The arguments to subtract.
	 * @return The result of the operation.
	 */
	BigDecimal diff(final List<BigDecimal> operators);
}
