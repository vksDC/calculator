package rodriguez.garcia.vanessa.calculator.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SimpleOperationsApiServiceTest {

	private SimpleOperationsApiService service;
	
	@Test
	void addSuccessfullyTest() {
		final BigDecimal operator1 = new BigDecimal(1);
		final BigDecimal operator2 = new BigDecimal(2);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final BigDecimal expectedResult = new BigDecimal(3);
		
		final BigDecimal result = service.add(operators);

		Assertions.assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	void addThrowsExceptionWhenEmptyOperatorsListTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.add(Collections.emptyList());
		});
	}
	
	@Test
	void addThrowsExceptionWhenNullOperatorsListTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.add(null);
		});
	}
	
	@Test
	void addThrowsExceptionWhenOnlyOneOperatorsInListTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.add(List.of(new BigDecimal(1)));
		});
	}
	
	@Test
	void diffSuccessfullyTest() {
		final BigDecimal operator1 = new BigDecimal(1);
		final BigDecimal operator2 = new BigDecimal(2);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final BigDecimal expectedResult = new BigDecimal(3);
		
		final BigDecimal result = service.diff(operators);

		Assertions.assertThat(result).isEqualTo(expectedResult);
	}
	
	@Test
	void diffThrowsExceptionWhenEmptyOperatorsListTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.diff(Collections.emptyList());
		});
	}
	
	@Test
	void diffThrowsExceptionWhenNullOperatorsListTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.diff(null);
		});
	}
	
	@Test
	void diffThrowsExceptionWhenOnlyOneOperatorsInListTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.diff(List.of(new BigDecimal(1)));
		});
	}
}
