package tasks.collections;

import static java.lang.String.format;

/**
 * SetTimeComparison.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/25/2018
 */
public class SetTimeComparison implements Comparative {

	/**
	 * compareTimeAddingElement.
	 * compareTimeAddingElement() method compares time of adding element between HashSet and TreeSet
	 *
	 * @param timeAddingElementIntoHashSet
	 * @param timeAddingElementIntoTreeSet
	 */
	@Override
	public void compareTimeAddingElement(double timeAddingElementIntoHashSet,
	                                     double timeAddingElementIntoTreeSet) {
		if (timeAddingElementIntoHashSet < timeAddingElementIntoTreeSet) {
			System.out.println(format("\nTime has been spent for adding an element into HashSet is %f",
					timeAddingElementIntoHashSet));
			System.out.println(format("Time has been spent for adding an element into TreeSet is %f",
					timeAddingElementIntoTreeSet));
			System.out.println("The operation of adding an element into the HashSet is faster than into the TreeSet");
		} else {
			System.out.println(format("\nTime has been spent for adding an element into HashSet is %f",
					timeAddingElementIntoHashSet));
			System.out.println(format("Time has been spent for adding an element into TreeSet is %f",
					timeAddingElementIntoTreeSet));
			System.out.println("The operation of adding an element into the TreeSet is faster than into the HashSet");
		}
	}

	/**
	 * compareTimeGettingElement.
	 * compareTimeGettingElement() method compares time of getting element from ArrayList and LinkedList
	 *
	 * @param timeGettingElementFromHashSet
	 * @param timeGettingElementFromTreeSet
	 */
	@Override
	public void compareTimeGettingElement(double timeGettingElementFromHashSet,
	                                      double timeGettingElementFromTreeSet) {
		if (timeGettingElementFromHashSet < timeGettingElementFromTreeSet) {
			System.out.println(format("\nTime has been spent for getting an element from HashSet is %f",
					timeGettingElementFromHashSet));
			System.out.println(format("Time has been spent for getting an element from TreeSet is %f",
					timeGettingElementFromTreeSet));
			System.out.println("The operation of getting an element from the HashSet is faster than from the TreeSet");
		} else {
			System.out.println(format("\nTime has been spent for getting an element from HashSet is %f",
					timeGettingElementFromHashSet));
			System.out.println(format("Time has been spent for getting an element from TreeSet is %f",
					timeGettingElementFromTreeSet));
			System.out.println("The operation of getting an element from the TreeSet is faster than from the HashSet");
		}
	}

	/**
	 * compareTimeRemovingElement.
	 * compareTimeRemovingElement() method compares time of removing element from ArrayList and LinkedList
	 *
	 * @param timeRemovingElementInHashSet
	 * @param timeRemovingElementInTreeSet
	 */
	@Override
	public void compareTimeRemovingElement(double timeRemovingElementInHashSet,
	                                       double timeRemovingElementInTreeSet) {
		if (timeRemovingElementInHashSet < timeRemovingElementInTreeSet) {
			System.out.println(format("\nTime has been spent for removing an element in HashSet is %f",
					timeRemovingElementInHashSet));
			System.out.println(format("Time has been spent for removing an element in TreeSet is %f",
					timeRemovingElementInTreeSet));
			System.out.println("The operation of removing an element in the HashSet is faster than in the TreeSet");
		} else {
			System.out.println(format("\nTime has been spent for removing an element in HashSet is %f",
					timeRemovingElementInHashSet));
			System.out.println(format("Time has been spent for removing an element in TreeSet is %f",
					timeRemovingElementInTreeSet));
			System.out.println("The operation of removing an element in the TreeSet is faster than in the HashSet");
		}
	}
}
