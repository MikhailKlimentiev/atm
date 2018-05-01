package tasks.collections;

import java.util.Scanner;

/**
 * Removable.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public interface Removable {

	/**
	 * countTimeRemovingElement.
	 * countTimeRemovingElement() method counts time of removing an element in collection
	 * @param scan
	 * @return (endTime - startTime)
	 */
	public double countTimeRemovingElement(Scanner scan);
}
