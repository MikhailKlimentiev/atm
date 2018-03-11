package tasks.exceptions;

/**
 * InvalidCarTypeException.
 * InvalidCarTypeException occurs if invalid Car Type passed into constructor as a parameter.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/11/2018
 */
public class InvalidCarTypeException extends Exception{
	public InvalidCarTypeException(String message) {
		super(message);
	}

	public InvalidCarTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public void warn() {
		System.err.println("You specified invalid car type. Please input car type according specified class.");
	}
}
