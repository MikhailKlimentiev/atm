package tasks.collections;

import java.util.Scanner;


public class Runner {
	public static void main(String[] args) {
		TimeComparison timeComparisonForArrayListAndLinkedList = new TimeComparison();
		Scanner scan = new Scanner(System.in);

		ArrayListExample arrayListExample = new ArrayListExample(10000);
		LinkedListExample linkedListExample = new LinkedListExample(10000);

		double timeForAddElementIntoArrayList = arrayListExample.addElementIntoArrayList(scan);
		double timeForAddElementIntoLinkedList = linkedListExample.addElementIntoLinkedList(scan);
		timeComparisonForArrayListAndLinkedList.compareArrayListAndLinkedListAddingElement(timeForAddElementIntoArrayList,
				timeForAddElementIntoLinkedList);

		double timeForGetElementIntoArrayList = arrayListExample.getArrayListElementByIndex(scan);
		double timeForGetElementIntoLinkedList = linkedListExample.getLinkedListElementByIndex(scan);
		timeComparisonForArrayListAndLinkedList.compareArrayListAndLinkedListGettingElement(timeForGetElementIntoArrayList,
				timeForGetElementIntoLinkedList);

		double timeForRemoveElementIntoArrayList = arrayListExample.removeArrayListElementByIndex(scan);
		double timeForRemoveElementIntoLinkedList = linkedListExample.removeLinkedListElementByIndex(scan);
		timeComparisonForArrayListAndLinkedList.compareArrayListAndLinkedListRemovingElement(timeForRemoveElementIntoArrayList,
				timeForRemoveElementIntoLinkedList);
	}







}