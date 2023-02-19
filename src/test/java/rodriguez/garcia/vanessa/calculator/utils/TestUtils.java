package rodriguez.garcia.vanessa.calculator.utils;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtils {

	public static <T> T performCallAndObtainOkResponse(final MockMvc mvc, final MockHttpServletRequestBuilder mockRequest,
			final Class<T> classToConvertTo) throws Exception {
		final ObjectMapper objectMapper = new ObjectMapper();
		
		final MvcResult result = mvc.perform(mockRequest)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andReturn();
		
		return objectMapper.readValue(result.getResponse().getContentAsString(), classToConvertTo);
	}
}
