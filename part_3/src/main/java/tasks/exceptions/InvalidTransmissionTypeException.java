package tasks.exceptions;

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
