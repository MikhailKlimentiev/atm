package tasks.exceptions;

public class InputNegativeNumberException extends Exception {
	public InputNegativeNumberException(String message) {
		super(message);
	}

	public InputNegativeNumberException(String message, Throwable cause) {
		super(message, cause);
	}

	public void warn() {
		System.err.println("Please input a positive number");
	}
}
