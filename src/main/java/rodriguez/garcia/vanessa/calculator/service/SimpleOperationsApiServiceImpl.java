package rodriguez.garcia.vanessa.calculator.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SimpleOperationsApiServiceImpl implements SimpleOperationsApiService {

	@Override
	public BigDecimal add(List<BigDecimal> operators) {
		if (CollectionUtils.isEmpty(operators) || operators.size() == 1) {
			throw new IllegalArgumentException("The minimum number of operators required to perform the operation is 2");
		}
		
		final BigDecimal result = operators.stream().reduce(BigDecimal::add).get();
		
		return result;
	}

	@Override
	public BigDecimal diff(List<BigDecimal> operators) {
		if (CollectionUtils.isEmpty(operators) || operators.size() == 1) {
			throw new IllegalArgumentException("The minimum number of operators required to perform the operation is 2");
		}
		
		final BigDecimal result = operators.stream().reduce((num1, num2) -> num1.subtract(num2)).get();
		
		return result;
	}
}
