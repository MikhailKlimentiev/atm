package tasks.deprecatedcollections;

import static java.lang.String.format;

/**
 * TimeComparison.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 02/22/2018
 */
public class TimeComparison {

	/**
	 * compareArrayListAndLinkedListAddingElement.
	 * The method compareArrayListAndLinkedListAddingElement compares adding elements time into ArrayList and LinkedList
	 * and prints result in console
	 * @param timeForAddingElementIntoArrayList
	 * @param timeForAddingElementIntoLinkedList
	 */
	public void compareArrayListAndLinkedListAddingElement(double timeForAddingElementIntoArrayList,
	                                                       double timeForAddingElementIntoLinkedList) {
		if (timeForAddingElementIntoArrayList < timeForAddingElementIntoLinkedList) {
			System.out.println(format("\nTime has been spent for adding an element into ArrayList is %f",
					timeForAddingElementIntoArrayList));
			System.out.println(format("Time has been spent for adding an element into LinkedList is %f",
					timeForAddingElementIntoLinkedList));
			System.out.println("The operation of adding an element into the ArrayList is faster than into the LinkedList");
		} else {
			System.out.println(format("\nTime has been spent for adding an element into ArrayList is %f",
					timeForAddingElementIntoArrayList));
			System.out.println(format("Time has been spent for adding an element into LinkedList is %f",
					timeForAddingElementIntoLinkedList));
			System.out.println("The operation of adding an element into the LinkedList is faster than into the ArrayList");
		}
	}

	/**
	 * compareArrayListAndLinkedListGettingElement.
	 * The method compareArrayListAndLinkedListGettingElement compares getting elements time from ArrayList and LinkedList
	 * and prints result in console
	 * @param timeForGettingElementFromArrayList
	 * @param timeForGettingElementFromLinkedList
	 */
	public void compareArrayListAndLinkedListGettingElement(double timeForGettingElementFromArrayList,
	                                                        double timeForGettingElementFromLinkedList) {
		if (timeForGettingElementFromArrayList < timeForGettingElementFromLinkedList) {
			System.out.println(format("\nTime has been spent for getting an element from ArrayList is %f",
					timeForGettingElementFromArrayList));
			System.out.println(format("Time has been spent for getting an element from LinkedList is %f",
					timeForGettingElementFromLinkedList));
			System.out.println("The operation of getting an element from the ArrayList is faster than from the LinkedList");
		} else {
			System.out.println(format("\nTime has been spent for getting element from ArrayList is %f",
					timeForGettingElementFromArrayList));
			System.out.println(format("Time has been spent for getting element from LinkedList is %f",
					timeForGettingElementFromLinkedList));
			System.out.println("The operation of getting an item from the LinkedList is faster than into the ArrayList");
		}
	}

	/**
	 * compareArrayListAndLinkedListRemovingElement.
	 * The method compareArrayListAndLinkedListRemovingElement compares removing elements time into ArrayList and LinkedList
	 * and prints result in console
	 * @param timeForRemovingElementFromArrayList
	 * @param timeForRemovingElementFromLinkedList
	 */
	public void compareArrayListAndLinkedListRemovingElement(double timeForRemovingElementFromArrayList,
	                                                         double timeForRemovingElementFromLinkedList) {
		if (timeForRemovingElementFromArrayList < timeForRemovingElementFromLinkedList) {
			System.out.println(format("\nTime has been spent for removing an element from ArrayList is %f",
					timeForRemovingElementFromArrayList));
			System.out.println(format("Time has been spent for removing an element from LinkedList is %f",
					timeForRemovingElementFromLinkedList));
			System.out.println("The operation of removing an element from the ArrayList is faster than into the LinkedList");
		} else {
			System.out.println(format("\nTime has been spent for removing an element from ArrayList is %f",
					timeForRemovingElementFromArrayList));
			System.out.println(format("Time has been spent for removing an element from LinkedList is %f",
					timeForRemovingElementFromLinkedList));
			System.out.println("The operation of removing an element from the LinkedList is faster than into the ArrayList");
		}
	}
}
