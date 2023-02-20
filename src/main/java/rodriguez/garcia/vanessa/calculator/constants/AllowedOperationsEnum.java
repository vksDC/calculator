package rodriguez.garcia.vanessa.calculator.constants;

import java.util.Arrays;

public enum AllowedOperationsEnum {

	ADD("add"),
	SUBTRACT("subtract");
	
	private String code;
	
	private AllowedOperationsEnum(final String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public static boolean isOperationAllowed(final String operation) {
		return Arrays.stream(AllowedOperationsEnum.values()).anyMatch(item -> item.getCode().equals(operation));
	}
}
