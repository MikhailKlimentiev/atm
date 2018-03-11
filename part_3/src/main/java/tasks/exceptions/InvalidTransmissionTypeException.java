package tasks.exceptions;

/**
 * InvalidTransmissionTypeException.
 * InvalidTransmissionTypeException occurs occurs if invalid Transmission Type passed into constructor as a parameter
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/11/2018
 */
public class InvalidTransmissionTypeException extends Exception {
	public InvalidTransmissionTypeException(String message) {
		super(message);
	}

	public InvalidTransmissionTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public void warn() {
		System.err.println("You specified invalid transmission type. Please input Manual or Automatic type.");
	}
}
