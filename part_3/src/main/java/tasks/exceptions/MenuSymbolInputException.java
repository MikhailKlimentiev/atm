package tasks.exceptions;

/**
 * MenuSymbolInputException.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/10/2018
 */
public class MenuSymbolInputException extends Exception {

	public MenuSymbolInputException(String message) {
		super(message);
	}

	public MenuSymbolInputException(String message, Throwable cause) {
		super(message, cause);
	}

}
