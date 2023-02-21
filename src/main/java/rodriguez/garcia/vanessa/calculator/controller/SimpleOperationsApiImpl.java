package rodriguez.garcia.vanessa.calculator.controller;

import java.text.MessageFormat;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.test.generated.api.controller.SimpleOperationsApi;
import com.test.generated.api.dto.CalculateRequestDto;
import com.test.generated.api.dto.OperationResultDto;

import io.corp.calculator.TracerImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import rodriguez.garcia.vanessa.calculator.service.SimpleOperationsApiService;

@RestController
@RequiredArgsConstructor
public class SimpleOperationsApiImpl implements SimpleOperationsApi {

	private static final TracerImpl TRACER = new TracerImpl();

	@NonNull
	private final SimpleOperationsApiService service;

	@Override
	public ResponseEntity<OperationResultDto> calculate(final String operationCode,
			@Valid final CalculateRequestDto calculateRequestDto) {
		TRACER.trace(MessageFormat.format("[START] calculate with operationCode: {0} and calculateRequestDto: {1}",
				operationCode, calculateRequestDto));

		final OperationResultDto response = new OperationResultDto()
				.code(operationCode)
				.operators(calculateRequestDto.getOperators())
				.result(service.calculate(operationCode, calculateRequestDto.getOperators()));

		TRACER.trace(MessageFormat.format("[END] calculate with response: {0}", response));

		return ResponseEntity.ok(response);
	}
}
