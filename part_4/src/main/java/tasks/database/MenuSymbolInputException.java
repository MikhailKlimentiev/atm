package tasks.database;

/**
 * MenuSymbolInputException.
 * MenuSymbolInputException occurs if a value getted from console is not matched to numbers which print in console menu
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

    public void warn() {
        System.err.println("Invalid Input. Please input a number from the list");
    }

}
