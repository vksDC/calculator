package rodriguez.garcia.vanessa.calculator.service;

import java.math.BigDecimal;
import java.util.List;

public interface SimpleOperationsApiService {

	BigDecimal add(final List<BigDecimal> operators);
	
	BigDecimal diff(final List<BigDecimal> operators);
}
