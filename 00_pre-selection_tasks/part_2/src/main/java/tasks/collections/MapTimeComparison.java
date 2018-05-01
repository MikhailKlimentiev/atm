package tasks.collections;

import static java.lang.String.format;

/**
 * MapTimeComparison.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/25/2018
 */
public class MapTimeComparison implements Comparative {

	/**
	 * compareTimeAddingElement.
	 * compareTimeAddingElement() method compares time of adding element between HashMap and TreeMap
	 *
	 * @param timeAddingElementIntoHashMap
	 * @param timeAddingElementIntoTreeMap
	 */
	@Override
	public void compareTimeAddingElement(double timeAddingElementIntoHashMap,
	                                     double timeAddingElementIntoTreeMap) {
		if (timeAddingElementIntoHashMap < timeAddingElementIntoTreeMap) {
			System.out.println(format("\nTime has been spent for adding an element into HashMap is %f.",
					timeAddingElementIntoHashMap));
			System.out.println(format("Time has been spent for adding an element into TreeMap is %f.",
					timeAddingElementIntoTreeMap));
			System.out.println("The operation of adding an element into the HashMap is faster than into the TreeMap.");
		} else {
			System.out.println(format("\nTime has been spent for adding an element into HashMap is %f.",
					timeAddingElementIntoHashMap));
			System.out.println(format("Time has been spent for adding an element into TreeMap is %f.",
					timeAddingElementIntoTreeMap));
			System.out.println("The operation of adding an element into the TreeMap is faster than into the HashMap.");
		}
	}

	/**
	 * compareTimeGettingElement.
	 * compareTimeGettingElement() method compares time of getting element between HashMap and TreeMap
	 *
	 * @param timeGettingElementFromHashMap
	 * @param timeGettingElementFromTreeMap
	 */
	@Override
	public void compareTimeGettingElement(double timeGettingElementFromHashMap,
	                                      double timeGettingElementFromTreeMap) {
		if (timeGettingElementFromHashMap < timeGettingElementFromTreeMap) {
			System.out.println(format("\nTime has been spent for getting an element from HashMap is %f.",
					timeGettingElementFromHashMap));
			System.out.println(format("Time has been spent for getting an element from TreeMap is %f.",
					timeGettingElementFromTreeMap));
			System.out.println("The operation of getting an element from the HashMap is faster than from the TreeMap.");
		} else {
			System.out.println(format("\nTime has been spent for getting an element from HashMap is %f.",
					timeGettingElementFromHashMap));
			System.out.println(format("Time has been spent for getting an element from TreeMap is %f.",
					timeGettingElementFromTreeMap));
			System.out.println("The operation of getting an element from the TreeMap is faster than from the HashMap.");
		}
	}

	/**
	 * compareTimeRemovingElement.
	 * compareTimeRemovingElement() method compares time of removing element between HashMap and TreeMap
	 *
	 * @param timeRemovingElementInHashMap
	 * @param timeRemovingElementInTreeMap
	 */
	@Override
	public void compareTimeRemovingElement(double timeRemovingElementInHashMap,
	                                       double timeRemovingElementInTreeMap) {
		if (timeRemovingElementInHashMap < timeRemovingElementInTreeMap) {
			System.out.println(format("\nTime has been spent for removing an element in HashMap is %f.",
					timeRemovingElementInHashMap));
			System.out.println(format("Time has been spent for removing an element in TreeMap is %f.",
					timeRemovingElementInTreeMap));
			System.out.println("The operation of removing an element in the HashMap is faster than in the TreeMap.");
		} else {
			System.out.println(format("\nTime has been spent for removing an element in HashMap is %f.",
					timeRemovingElementInHashMap));
			System.out.println(format("Time has been spent for removing an element in TreeMap is %f.",
					timeRemovingElementInTreeMap));
			System.out.println("The operation of removing an element in the TreeMap is faster than in the HashMap.");
		}
	}
}
