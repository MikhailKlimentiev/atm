package tasks.collections;

import java.util.Scanner;

/**
 * Derivable.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public interface Derivable {

	/**
	 * countTimeGettingElement.
	 * countTimeGettingElement() method counts time of getting an element from collection
	 * @param scan
	 * @return (endTime - startTime)
	 */
	public double countTimeGettingElement(Scanner scan);
}
