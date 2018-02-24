package tasks.collections;

import java.util.Scanner;

/**
 * Insertable.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public interface Insertable {

	/**
	 * countTimeAddingElement.
	 * countTimeAddingElement() method counts time of adding an element into collection
	 * @param scan
	 * @return (endTime - startTime)
	 */
	public double countTimeAddingElement(Scanner scan);
}
