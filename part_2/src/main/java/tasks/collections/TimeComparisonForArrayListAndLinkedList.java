package tasks.collections;

import static java.lang.String.format;

public class TimeComparisonForArrayListAndLinkedList {
	public void compareArrayListAndLinkedListAddElement(double timeForAddElementIntoArrayList, double timeForAddElementIntoLinkedList) {
		if (timeForAddElementIntoArrayList < timeForAddElementIntoLinkedList) {
			System.out.println(format("\nTime has been spent for adding element into ArrayList is %f", timeForAddElementIntoArrayList));
			System.out.println(format("Time has been spent for adding element into LinkedList is %f", timeForAddElementIntoLinkedList));
			System.out.println("The operation of adding an item into the ArrayList is faster than into the LinkedList");
		} else
			System.out.println(format("\nTime has been spent for adding element into ArrayList is %f", timeForAddElementIntoArrayList));
		System.out.println(format("Time has been spent for adding element into LinkedList is %f", timeForAddElementIntoLinkedList));
		System.out.println("The operation of adding an item into the LinkedList is faster than into the ArrayList");
	}

	public void compareArrayListAndLinkedListGetElement(double timeForGetElementIntoArrayList, double timeForGetElementIntoLinkedList) {
		if (timeForGetElementIntoArrayList < timeForGetElementIntoLinkedList) {
			System.out.println(format("\nTime has been spent for getting element from ArrayList is %f", timeForGetElementIntoArrayList));
			System.out.println(format("Time has been spent for getting element from LinkedList is %f", timeForGetElementIntoLinkedList));
			System.out.println("The operation of getting an item from the ArrayList is faster than from the LinkedList");
		} else
			System.out.println(format("\nTime has been spent for getting element from ArrayList is %f", timeForGetElementIntoArrayList));
		System.out.println(format("Time has been spent for getting element from LinkedList is %f", timeForGetElementIntoLinkedList));
		System.out.println("The operation of getting an item from the LinkedList is faster than into the ArrayList");
	}

	public void compareArrayListAndLinkedListRemoveElement(double timeForRemoveElementIntoArrayList, double timeForRemoveElementIntoLinkedList) {
		if (timeForRemoveElementIntoArrayList < timeForRemoveElementIntoLinkedList) {
			System.out.println(format("\nTime has been spent for removing element into ArrayList is %f", timeForRemoveElementIntoArrayList));
			System.out.println(format("Time has been spent for removing element into LinkedList is %f", timeForRemoveElementIntoLinkedList));
			System.out.println("The operation of removing an item into the ArrayList is faster than into the LinkedList");
		} else
			System.out.println(format("\nTime has been spent for removing element into ArrayList is %f", timeForRemoveElementIntoArrayList));
		System.out.println(format("Time has been spent for removing element into LinkedList is %f", timeForRemoveElementIntoLinkedList));
		System.out.println("The operation of removing an item into the LinkedList is faster than into the ArrayList");
	}
}
