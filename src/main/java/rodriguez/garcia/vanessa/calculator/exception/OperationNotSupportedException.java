package rodriguez.garcia.vanessa.calculator.exception;

import java.text.MessageFormat;

/**
 * Custom exception to indicate that the requested operation is not supported.
 */
public class OperationNotSupportedException extends RuntimeException {

	private static final long serialVersionUID = 6459177012095015804L;

	public OperationNotSupportedException() {}
	
	public OperationNotSupportedException(final String message) {
		super(MessageFormat.format("The operation {0} is not supported", message));
	}
}
