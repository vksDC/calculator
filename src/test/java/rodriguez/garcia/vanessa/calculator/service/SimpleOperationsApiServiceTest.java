package rodriguez.garcia.vanessa.calculator.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import rodriguez.garcia.vanessa.calculator.exception.OperationNotSupportedException;

@ExtendWith(MockitoExtension.class)
class SimpleOperationsApiServiceTest {
	private static final String ADD = "add";
	
	private static final String SUBTRACT = "subtract";

	@Spy
	private SimpleOperationsApiServiceImpl service;
	
	@Test
	void add_Successfully() {
		final BigDecimal operator1 = new BigDecimal(1);
		final BigDecimal operator2 = new BigDecimal(2);
		final List<BigDecimal> operators = new ArrayList<>(Arrays.asList(operator1, operator2));
		final BigDecimal expectedResult = new BigDecimal(3);
		
		final BigDecimal result = service.calculate(ADD, operators);

		Assertions.assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	void add_SuccessfullyWhenOperatorIsMaxValue() {
		final BigDecimal operator1 = new BigDecimal(Double.MAX_VALUE);
		final BigDecimal operator2 = new BigDecimal(Double.MAX_VALUE);
		final List<BigDecimal> operators = new ArrayList<>(Arrays.asList(operator1, operator2));
		final BigDecimal expectedResult = operator1.add(operator2);
		
		final BigDecimal result = service.calculate(ADD, operators);

		Assertions.assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	void add_ThrowsException_WhenEmptyOperatorsList() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(ADD, Collections.emptyList());
		});
	}
	
	@Test
	void add_ThrowsException_WhenNullOperatorsList() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(ADD, null);
		});
	}
	
	@Test
	void add_ThrowsException_WhenOnlyOneOperatorsInList() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(ADD, List.of(new BigDecimal(1)));
		});
	}
	
	@Test
	void add_ThrowsIllegalArgumentException_WhenAnOperatorIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(ADD, new ArrayList<>(Arrays.asList(new BigDecimal(1), null)));
		});
	}
	
	@Test
	void subtract_Successfully() {
		final BigDecimal operator1 = new BigDecimal(1);
		final BigDecimal operator2 = new BigDecimal(2);
		final List<BigDecimal> operators = new ArrayList<>(Arrays.asList(operator1, operator2));
		final BigDecimal expectedResult = new BigDecimal(-1);
		
		final BigDecimal result = service.calculate(SUBTRACT, operators);

		Assertions.assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	void subtract_SuccessfullyWhenOperatorIsMaxValue() {
		final BigDecimal operator1 = new BigDecimal(Double.MIN_VALUE);
		final BigDecimal operator2 = new BigDecimal(1);
		final List<BigDecimal> operators = new ArrayList<>(Arrays.asList(operator1, operator2));
		final BigDecimal expectedResult = operator1.subtract(operator2);
		
		final BigDecimal result = service.calculate(SUBTRACT, operators);

		Assertions.assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	void subtract_ThrowsException_WhenEmptyOperatorsList() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(SUBTRACT, Collections.emptyList());
		});
	}
	
	@Test
	void subtract_ThrowsException_WhenNullOperatorsList() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(SUBTRACT, null);
		});
	}
	
	@Test
	void subtract_ThrowsException_WhenOnlyOneOperatorsInList() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(SUBTRACT, List.of(new BigDecimal(1)));
		});
	}
	
	@Test
	void subtract_ThrowsIllegalArgumentException_WhenAnOperatorIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.calculate(SUBTRACT, new ArrayList<>(Arrays.asList(new BigDecimal(1), null)));
		});
	}
	
	@Test
	void calculate_ThrowsOperationNotSupportedException() {
		final BigDecimal operator1 = new BigDecimal(1);
		final BigDecimal operator2 = new BigDecimal(2);
		final List<BigDecimal> operators = new ArrayList<>(Arrays.asList(operator1, operator2));
		
		assertThrows(OperationNotSupportedException.class, () -> {
			service.calculate("divide", operators);
		});
	}
}
