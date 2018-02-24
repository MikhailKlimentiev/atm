package tasks.collections;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ArrayListExample arrayListExample = new ArrayListExample(20000);
		LinkedListExample linkedListExample = new LinkedListExample(20000);
		ListTimeComparison listTimeComparison = new ListTimeComparison();

		double timeAddingElementIntoArrayList = arrayListExample.countTimeAddingElement(scan);
		double timeAddingElementIntoLinkedList = linkedListExample.countTimeAddingElement(scan);
		listTimeComparison.compareTimeAddingElement(timeAddingElementIntoArrayList,timeAddingElementIntoLinkedList);

		double timeGettingElementFromArrayList = arrayListExample.countTimeGettingElement(scan);
		double timeGettingElementFromLinkedList = linkedListExample.countTimeGettingElement(scan);
		listTimeComparison.compareTimeGettingElement(timeGettingElementFromArrayList,timeGettingElementFromLinkedList);

		double timeRemovingElementInArrayList = arrayListExample.countTimeRemovingElement(scan);
		double timeRemovingElementInLinkedList = linkedListExample.countTimeRemovingElement(scan);
		listTimeComparison.compareTimeRemovingElement(timeRemovingElementInArrayList, timeRemovingElementInLinkedList);

	}
}
