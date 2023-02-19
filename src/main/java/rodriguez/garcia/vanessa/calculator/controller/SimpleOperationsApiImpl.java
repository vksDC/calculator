package rodriguez.garcia.vanessa.calculator.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.test.generated.api.controller.SimpleOperationsApi;
import com.test.generated.api.dto.CalculateRequestDto;
import com.test.generated.api.dto.OperationResultDto;

import rodriguez.garcia.vanessa.calculator.service.SimpleOperationsApiService;

@RestController
public class SimpleOperationsApiImpl implements SimpleOperationsApi {
	private static final String OPERATION_ADD = "add";
	
	private static final String OPERATION_DIFF = "diff";

	@Autowired
	private SimpleOperationsApiService service;

	@Override
	public ResponseEntity<OperationResultDto> calculate(final String operationCode,
			@Valid final CalculateRequestDto calculateRequestDto) {

		if(!OPERATION_ADD.equals(operationCode) && !OPERATION_DIFF.equals(operationCode)) {
			throw new IllegalArgumentException(operationCode);
		}
	
		BigDecimal result = null;
		
		if (OPERATION_ADD.equals(operationCode)) {
			result = service.add(calculateRequestDto.getOperators());
		}
		if (OPERATION_DIFF.equals(operationCode)) {
			result = service.diff(calculateRequestDto.getOperators());
		}
		
		final OperationResultDto response = new OperationResultDto()
				.code(operationCode)
				.operators(calculateRequestDto.getOperators())
				.result(result);
		
		return ResponseEntity.ok(response);
	}
}
