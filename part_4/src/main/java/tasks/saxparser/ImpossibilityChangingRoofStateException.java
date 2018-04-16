package tasks.saxparser;

/**
 * ImpossibilityChangingRoofStateException.
 * ImpossibilityChangingRoofStateException occurs if there is an attempt to raise the roof of Cabriolet object
 * if roof is already raised and to lower the roof of Cabriolet object if roof is already lowered
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/11/2018
 */
public class ImpossibilityChangingRoofStateException extends Exception {
    public ImpossibilityChangingRoofStateException(String message) {
        super(message);
    }

    public ImpossibilityChangingRoofStateException(String message, Throwable cause) {
        super(message, cause);
    }
}
