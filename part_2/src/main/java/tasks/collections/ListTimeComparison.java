package tasks.collections;

import static java.lang.String.format;

/**
 * ListTimeComparison.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public class ListTimeComparison implements Comparative {

	/**
	 * compareTimeAddingElement.
	 * compareTimeAddingElement() method compares time of adding element between ArrayList and LinkedList
	 *
	 * @param timeAddingElementIntoArrayList
	 * @param timeAddingElementIntoLinkedList
	 */
	@Override
	public void compareTimeAddingElement(double timeAddingElementIntoArrayList,
	                                     double timeAddingElementIntoLinkedList) {
		if (timeAddingElementIntoArrayList < timeAddingElementIntoLinkedList) {
			System.out.println(format("\nTime has been spent for adding an element into ArrayList is %f.",
					timeAddingElementIntoArrayList));
			System.out.println(format("Time has been spent for adding an element into LinkedList is %f.",
					timeAddingElementIntoLinkedList));
			System.out.println("The operation of adding an element into the ArrayList is faster than into the LinkedList.");
		} else {
			System.out.println(format("\nTime has been spent for adding an element into ArrayList is %f.",
					timeAddingElementIntoArrayList));
			System.out.println(format("Time has been spent for adding an element into LinkedList is %f.",
					timeAddingElementIntoLinkedList));
			System.out.println("The operation of adding an element into the LinkedList is faster than into the ArrayList.");
		}
	}

	/**
	 * compareTimeGettingElement.
	 * compareTimeGettingElement() method compares time of getting element between ArrayList and LinkedList
	 *
	 * @param timeGettingElementFromArrayList
	 * @param timeGettingElementFromLinkedList
	 */
	@Override
	public void compareTimeGettingElement(double timeGettingElementFromArrayList,
	                                      double timeGettingElementFromLinkedList) {
		if (timeGettingElementFromArrayList < timeGettingElementFromLinkedList) {
			System.out.println(format("\nTime has been spent for getting an element from ArrayList is %f.",
					timeGettingElementFromArrayList));
			System.out.println(format("Time has been spent for getting an element from LinkedList is %f.",
					timeGettingElementFromLinkedList));
			System.out.println("The operation of getting an element from the ArrayList is faster than from the LinkedList.");
		} else {
			System.out.println(format("\nTime has been spent for getting an element from ArrayList is %f.",
					timeGettingElementFromArrayList));
			System.out.println(format("Time has been spent for getting an element from LinkedList is %f.",
					timeGettingElementFromLinkedList));
			System.out.println("The operation of getting an element from the LinkedList is faster than from the ArrayList.");
		}
	}

	/**
	 * compareTimeRemovingElement.
	 * compareTimeRemovingElement() method compares time of removing element between ArrayList and LinkedList
	 *
	 * @param timeRemovingElementInArrayList
	 * @param timeRemovingElementInLinkedList
	 */
	@Override
	public void compareTimeRemovingElement(double timeRemovingElementInArrayList,
	                                       double timeRemovingElementInLinkedList) {
		if (timeRemovingElementInArrayList < timeRemovingElementInLinkedList) {
			System.out.println(format("\nTime has been spent for removing an element in ArrayList is %f.",
					timeRemovingElementInArrayList));
			System.out.println(format("Time has been spent for removing an element in LinkedList is %f.",
					timeRemovingElementInLinkedList));
			System.out.println("The operation of removing an element in the ArrayList is faster than in the LinkedList.");
		} else {
			System.out.println(format("\nTime has been spent for removing an element in ArrayList is %f.",
					timeRemovingElementInArrayList));
			System.out.println(format("Time has been spent for removing an element in LinkedList is %f.",
					timeRemovingElementInLinkedList));
			System.out.println("The operation of removing an element in the LinkedList is faster than in the ArrayList.");
		}
	}
}
