package rodriguez.garcia.vanessa.calculator.controller;

import java.math.BigDecimal;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.generated.api.dto.CalculateRequestDto;
import com.test.generated.api.dto.ErrorDto;
import com.test.generated.api.dto.OperationResultDto;

import rodriguez.garcia.vanessa.calculator.service.SimpleOperationsApiService;
import rodriguez.garcia.vanessa.calculator.utils.TestUtils;

@WebMvcTest(SimpleOperationsApiImpl.class)
@ExtendWith(MockitoExtension.class)
class SimpleOperationsApiTest {

	private static final String ENDPOINT = "/operations/{operationCode}";

	private static final String ENCODING = "UTF-8";

	private static final String OPERATION_ADD = "add";

	private static final String OPERATION_DIFF = "diff";

	@MockBean
	private SimpleOperationsApiService service;

	@Autowired
	private MockMvc mvc;

	@Test
	void calculateAddSuccessfullyTest() throws Exception {
		final BigDecimal operator1 = new BigDecimal(1);
		final BigDecimal operator2 = new BigDecimal(2);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final CalculateRequestDto requestDto = new CalculateRequestDto().operators(operators);
		final BigDecimal expectedResult = new BigDecimal(3);
		final OperationResultDto expectedResponse = new OperationResultDto().code(OPERATION_ADD).operators(operators)
				.result(expectedResult);

		Mockito.when(service.add(operators)).thenReturn(expectedResult);

		final MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(ENDPOINT, OPERATION_ADD)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding(ENCODING)
				.content(new ObjectMapper().writeValueAsString(requestDto));

		final OperationResultDto response = TestUtils.performCallAndObtainOkResponse(mvc, mockRequest,
				OperationResultDto.class);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
	}

	@Test
	void calculateAddResultZeroTest() throws Exception {
		final BigDecimal operator1 = new BigDecimal(1);
		final BigDecimal operator2 = new BigDecimal(-1);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final CalculateRequestDto requestDto = new CalculateRequestDto().operators(operators);
		final BigDecimal expectedResult = new BigDecimal(0);
		final OperationResultDto expectedResponse = new OperationResultDto().code(OPERATION_ADD).operators(operators)
				.result(expectedResult);

		Mockito.when(service.add(operators)).thenReturn(expectedResult);

		final MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(ENDPOINT, OPERATION_ADD)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding(ENCODING)
				.content(new ObjectMapper().writeValueAsString(requestDto));

		final OperationResultDto response = TestUtils.performCallAndObtainOkResponse(mvc, mockRequest,
				OperationResultDto.class);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
	}

	@Test
	void calculateAddWhenOneOperatorIsZeroTest() throws Exception {
		final BigDecimal operator1 = new BigDecimal(1);
		final BigDecimal operator2 = new BigDecimal(0);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final CalculateRequestDto requestDto = new CalculateRequestDto().operators(operators);
		final BigDecimal expectedResult = new BigDecimal(1);
		final OperationResultDto expectedResponse = new OperationResultDto().code(OPERATION_ADD).operators(operators)
				.result(expectedResult);

		Mockito.when(service.add(operators)).thenReturn(expectedResult);

		final MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(ENDPOINT, OPERATION_ADD)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding(ENCODING)
				.content(new ObjectMapper().writeValueAsString(requestDto));

		final OperationResultDto response = TestUtils.performCallAndObtainOkResponse(mvc, mockRequest,
				OperationResultDto.class);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
	}

	@Test
	void calculateAddWhenOneOperatorIsNegativeTest() throws Exception {
		final BigDecimal operator1 = new BigDecimal(1);
		final BigDecimal operator2 = new BigDecimal(-2);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final CalculateRequestDto requestDto = new CalculateRequestDto().operators(operators);
		final BigDecimal expectedResult = new BigDecimal(-1);
		final OperationResultDto expectedResponse = new OperationResultDto().code(OPERATION_ADD).operators(operators)
				.result(expectedResult);

		Mockito.when(service.add(operators)).thenReturn(expectedResult);

		final MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(ENDPOINT, OPERATION_ADD)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding(ENCODING)
				.content(new ObjectMapper().writeValueAsString(requestDto));

		final OperationResultDto response = TestUtils.performCallAndObtainOkResponse(mvc, mockRequest,
				OperationResultDto.class);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
	}

	@Test
	void calculateAddWhenBothOperatorsAreNegativeTest() throws Exception {
		final BigDecimal operator1 = new BigDecimal(-1);
		final BigDecimal operator2 = new BigDecimal(-2);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final CalculateRequestDto requestDto = new CalculateRequestDto().operators(operators);
		final BigDecimal expectedResult = new BigDecimal(-3);
		final OperationResultDto expectedResponse = new OperationResultDto().code(OPERATION_ADD).operators(operators)
				.result(expectedResult);

		Mockito.when(service.add(operators)).thenReturn(expectedResult);

		final MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(ENDPOINT, OPERATION_ADD)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding(ENCODING)
				.content(new ObjectMapper().writeValueAsString(requestDto));

		final OperationResultDto response = TestUtils.performCallAndObtainOkResponse(mvc, mockRequest,
				OperationResultDto.class);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
	}

	@Test
	void calculateDiffSuccessfullyTest() throws Exception {
		final BigDecimal operator1 = new BigDecimal(2);
		final BigDecimal operator2 = new BigDecimal(1);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final CalculateRequestDto requestDto = new CalculateRequestDto().operators(operators);
		final BigDecimal expectedResult = new BigDecimal(1);
		final OperationResultDto expectedResponse = new OperationResultDto().code(OPERATION_DIFF).operators(operators)
				.result(expectedResult);

		Mockito.when(service.diff(operators)).thenReturn(expectedResult);

		final MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(ENDPOINT, OPERATION_DIFF)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding(ENCODING)
				.content(new ObjectMapper().writeValueAsString(requestDto));

		final OperationResultDto response = TestUtils.performCallAndObtainOkResponse(mvc, mockRequest,
				OperationResultDto.class);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
	}

	@Test
	void calculateDiffResultZeroTest() throws Exception {
		final BigDecimal operator1 = new BigDecimal(2);
		final BigDecimal operator2 = new BigDecimal(2);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final CalculateRequestDto requestDto = new CalculateRequestDto().operators(operators);
		final BigDecimal expectedResult = new BigDecimal(0);
		final OperationResultDto expectedResponse = new OperationResultDto().code(OPERATION_DIFF).operators(operators)
				.result(expectedResult);

		Mockito.when(service.diff(operators)).thenReturn(expectedResult);

		final MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(ENDPOINT, OPERATION_DIFF)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding(ENCODING)
				.content(new ObjectMapper().writeValueAsString(requestDto));

		final OperationResultDto response = TestUtils.performCallAndObtainOkResponse(mvc, mockRequest,
				OperationResultDto.class);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
	}

	@Test
	void calculateDiffOneOperatorIsNegativeTest() throws Exception {
		final BigDecimal operator1 = new BigDecimal(-1);
		final BigDecimal operator2 = new BigDecimal(2);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final CalculateRequestDto requestDto = new CalculateRequestDto().operators(operators);
		final BigDecimal expectedResult = new BigDecimal(-3);
		final OperationResultDto expectedResponse = new OperationResultDto().code(OPERATION_DIFF).operators(operators)
				.result(expectedResult);

		Mockito.when(service.diff(operators)).thenReturn(expectedResult);

		final MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(ENDPOINT, OPERATION_DIFF)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding(ENCODING)
				.content(new ObjectMapper().writeValueAsString(requestDto));

		final OperationResultDto response = TestUtils.performCallAndObtainOkResponse(mvc, mockRequest,
				OperationResultDto.class);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
	}

	@Test
	void calculateDiffBothOperatorsAreNegativeTest() throws Exception {
		final BigDecimal operator1 = new BigDecimal(-1);
		final BigDecimal operator2 = new BigDecimal(-2);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final CalculateRequestDto requestDto = new CalculateRequestDto().operators(operators);
		final BigDecimal expectedResult = new BigDecimal(1);
		final OperationResultDto expectedResponse = new OperationResultDto().code(OPERATION_DIFF).operators(operators)
				.result(expectedResult);

		Mockito.when(service.diff(operators)).thenReturn(expectedResult);

		final MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(ENDPOINT, OPERATION_DIFF)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding(ENCODING)
				.content(new ObjectMapper().writeValueAsString(requestDto));

		final OperationResultDto response = TestUtils.performCallAndObtainOkResponse(mvc, mockRequest,
				OperationResultDto.class);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
	}

	@Test
	void calculateThrowsIllegalArgumentExceptionTest() throws Exception {
		final BigDecimal operator1 = new BigDecimal(1);
		final BigDecimal operator2 = new BigDecimal(2);
		final List<BigDecimal> operators = List.of(operator1, operator2);
		final CalculateRequestDto requestDto = new CalculateRequestDto().operators(operators);
		final BigDecimal expectedResult = new BigDecimal(3);
		final ErrorDto expectedResponse = new ErrorDto().code(400).message("Operation divide not allowed");

		Mockito.when(service.add(operators)).thenReturn(expectedResult);

		final MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post(ENDPOINT, "divide")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).characterEncoding(ENCODING)
				.content(new ObjectMapper().writeValueAsString(requestDto));

		final ErrorDto response = TestUtils.performCallAndObtainBadRequestResponse(mvc, mockRequest,
				ErrorDto.class);

		Assertions.assertThat(response).usingRecursiveComparison().isEqualTo(expectedResponse);
	}
}
