package rodriguez.garcia.vanessa.calculator.controller;

import java.math.BigDecimal;
import java.text.MessageFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.test.generated.api.controller.SimpleOperationsApi;
import com.test.generated.api.dto.CalculateRequestDto;
import com.test.generated.api.dto.OperationResultDto;

import io.corp.calculator.TracerImpl;
import rodriguez.garcia.vanessa.calculator.service.SimpleOperationsApiService;

@RestController
public class SimpleOperationsApiImpl implements SimpleOperationsApi {
	private static final String OPERATION_ADD = "add";

	private static final String OPERATION_DIFF = "diff";

	private static final TracerImpl TRACER = new TracerImpl();

	@Autowired
	private SimpleOperationsApiService service;

	@Override
	public ResponseEntity<OperationResultDto> calculate(final String operationCode,
			@Valid final CalculateRequestDto calculateRequestDto) {
		TRACER.trace(MessageFormat.format("[START] calculate with operationCode: {0} and calculateRequestDto: {1}",
				operationCode, calculateRequestDto));

		if (!OPERATION_ADD.equals(operationCode) && !OPERATION_DIFF.equals(operationCode)) {
			throw new UnsupportedOperationException(operationCode);
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

		TRACER.trace(MessageFormat.format("[END] calculate with response: {0}", response));

		return ResponseEntity.ok(response);
	}
}
