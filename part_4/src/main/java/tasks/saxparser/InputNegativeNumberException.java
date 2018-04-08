package tasks.saxparser;

/**
 * InputNegativeNumberException.
 * InputNegativeNumberException occurs if getted negative number
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/11/2018
 */
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
