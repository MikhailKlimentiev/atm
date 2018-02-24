package tasks.collections;

/**
 * Comparative.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public interface Comparative {
	/**
	 * compareTimeAddingElement.
	 * compareTimeAddingElement() method compares time of adding element between two collections
	 * @param timeAddingElementIntoFirstCollection
	 * @param timeAddingElementIntoSecondCollection
	 */
	public void compareTimeAddingElement(double timeAddingElementIntoFirstCollection,
	                                     double timeAddingElementIntoSecondCollection);

	/**
	 * compareTimeGettingElement.
	 * compareTimeGettingElement() method compares time of getting element between two collections
	 * @param timeGettingElementFromFirstCollection
	 * @param timeGettingElementFromSecondCollection
	 */
	public void compareTimeGettingElement(double timeGettingElementFromFirstCollection,
	                                     double timeGettingElementFromSecondCollection);

	/**
	 * compareTimeRemovingElement.
	 * compareTimeGettingElement() method compares time of removing element between two collections
	 * @param timeRemovingElementInFirstCollection
	 * @param timeRemovingElementInSecondCollection
	 */
	public void compareTimeRemovingElement(double timeRemovingElementInFirstCollection,
	                                      double timeRemovingElementInSecondCollection);

}




