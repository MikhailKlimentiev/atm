package tasks.database;

/**
 * EmptyCollectionException.
 * EmptyCollectionException occurs if getted collection is empty
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/11/2018
 */
public class EmptyCollectionException extends Exception {
    public EmptyCollectionException(String message) {
        super(message);
    }

    public EmptyCollectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public void warn() {
        System.err.println("Taxi Station collection is empty");
    }
}
