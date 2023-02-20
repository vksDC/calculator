package rodriguez.garcia.vanessa.calculator.service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import io.corp.calculator.TracerImpl;
import rodriguez.garcia.vanessa.calculator.constants.AllowedOperationsEnum;
import rodriguez.garcia.vanessa.calculator.exception.OperationNotSupportedException;

@Component
public class SimpleOperationsApiServiceImpl implements SimpleOperationsApiService {

	private static final TracerImpl TRACER = new TracerImpl();

	@Override
	public BigDecimal calculate(final String operationCode, final List<BigDecimal> operators) {
		TRACER.trace(MessageFormat.format("[START] calculate with operationCode: {0} and operators: {1}", operationCode,
				operators));
		
		if (!AllowedOperationsEnum.isOperationAllowed(operationCode)) {
			throw new OperationNotSupportedException(operationCode);
		}

		if (CollectionUtils.isEmpty(operators) || operators.size() == 1 || operators.contains(null)) {
			throw new IllegalArgumentException();
		}
		
		BigDecimal result = null;
		if (AllowedOperationsEnum.ADD.getCode().equals(operationCode)) {
			result = this.add(operators);
		}

		if (AllowedOperationsEnum.SUBTRACT.getCode().equals(operationCode)) {
			result = this.subtract(operators);
		}
		
		TRACER.trace(MessageFormat.format("[END] calculate with result: {0}", result));

		return result;
	}

	private BigDecimal add(final List<BigDecimal> operators) {
		TRACER.trace(MessageFormat.format("[START] add with operators: {0}", operators));

		final BigDecimal result = operators.stream().reduce(BigDecimal::add).get();

		TRACER.trace(MessageFormat.format("[END] add with result: {0}", result));

		return result;
	}

	private BigDecimal subtract(List<BigDecimal> operators) {
		TRACER.trace(MessageFormat.format("[START] subtract with operators: {0}", operators));

		final BigDecimal result = operators.stream().reduce((num1, num2) -> num1.subtract(num2)).get();

		TRACER.trace(MessageFormat.format("[END] subtract with result: {0}", result));

		return result;
	}
}
