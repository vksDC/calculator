package rodriguez.garcia.vanessa.calculator.service;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import io.corp.calculator.TracerImpl;

@Component
public class SimpleOperationsApiServiceImpl implements SimpleOperationsApiService {
	
	private static final TracerImpl TRACER = new TracerImpl();

	@Override
	public BigDecimal add(List<BigDecimal> operators) {
		TRACER.trace(MessageFormat.format("[START] add with operators: {0}", operators));
		
		if (CollectionUtils.isEmpty(operators) || operators.size() == 1) {
			throw new IllegalArgumentException();
		}
		
		final BigDecimal result = operators.stream().reduce(BigDecimal::add).get();
		
		TRACER.trace(MessageFormat.format("[END] add with result: {0}", result));
		
		return result;
	}

	@Override
	public BigDecimal diff(List<BigDecimal> operators) {
		TRACER.trace(MessageFormat.format("[START] diff with operators: {0}", operators));
		
		if (CollectionUtils.isEmpty(operators) || operators.size() == 1) {
			throw new IllegalArgumentException();
		}
		
		final BigDecimal result = operators.stream().reduce((num1, num2) -> num1.subtract(num2)).get();
		
		TRACER.trace(MessageFormat.format("[END] diff with result: {0}", result));
		
		return result;
	}
}
