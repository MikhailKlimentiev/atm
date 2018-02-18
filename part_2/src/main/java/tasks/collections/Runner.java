package tasks.collections;

import java.util.Scanner;


public class Runner {
	public static void main(String[] args) {
		TimeComparisonForArrayListAndLinkedList timeComparisonForArrayListAndLinkedList = new TimeComparisonForArrayListAndLinkedList();
		Scanner scan = new Scanner(System.in);

		ArrayListExample arrayListExample = new ArrayListExample(10000);
		LinkedListExample linkedListExample = new LinkedListExample(10000);

		double timeForAddElementIntoArrayList = arrayListExample.addElementIntoArrayList(scan);
		double timeForAddElementIntoLinkedList = linkedListExample.addElementIntoLinkedList(scan);
		timeComparisonForArrayListAndLinkedList.compareArrayListAndLinkedListAddElement(timeForAddElementIntoArrayList, timeForAddElementIntoLinkedList);

		double timeForGetElementIntoArrayList = arrayListExample.getArrayListElementByIndex(scan);
		double timeForGetElementIntoLinkedList = linkedListExample.getLinkedListElementByIndex(scan);
		timeComparisonForArrayListAndLinkedList.compareArrayListAndLinkedListGetElement(timeForGetElementIntoArrayList, timeForGetElementIntoLinkedList);

		double timeForRemoveElementIntoArrayList = arrayListExample.removeArrayListElementByIndex(scan);
		double timeForRemoveElementIntoLinkedList = linkedListExample.removeLinkedListElementByIndex(scan);
		timeComparisonForArrayListAndLinkedList.compareArrayListAndLinkedListRemoveElement(timeForRemoveElementIntoArrayList, timeForRemoveElementIntoLinkedList);
	}







}