package tasks.collections;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		//Lists
		ArrayListExample arrayListExample = new ArrayListExample(15000);
		LinkedListExample linkedListExample = new LinkedListExample(15000);
		ListTimeComparison listTimeComparison = new ListTimeComparison();

		//Add into Lists
		double timeAddingElementIntoArrayList = arrayListExample.countTimeAddingElement(scan);
		double timeAddingElementIntoLinkedList = linkedListExample.countTimeAddingElement(scan);
		listTimeComparison.compareTimeAddingElement(timeAddingElementIntoArrayList,timeAddingElementIntoLinkedList);

		//Get from Lists
		double timeGettingElementFromArrayList = arrayListExample.countTimeGettingElement(scan);
		double timeGettingElementFromLinkedList = linkedListExample.countTimeGettingElement(scan);
		listTimeComparison.compareTimeGettingElement(timeGettingElementFromArrayList,timeGettingElementFromLinkedList);

		//Remove in Lists
		double timeRemovingElementInArrayList = arrayListExample.countTimeRemovingElement(scan);
		double timeRemovingElementInLinkedList = linkedListExample.countTimeRemovingElement(scan);
		listTimeComparison.compareTimeRemovingElement(timeRemovingElementInArrayList, timeRemovingElementInLinkedList);

		//Sets
		HashSetExample hashSetExample = new HashSetExample(15000);
		TreeSetExample treeSetExample = new TreeSetExample(15000);
		SetTimeComparison setTimeComparison = new SetTimeComparison();

		//Add into Sets
		double timeAddingElementIntoHashSet = hashSetExample.countTimeAddingElement(scan);
		double timeAddingElementIntoTreeSet = treeSetExample.countTimeAddingElement(scan);
		setTimeComparison.compareTimeAddingElement(timeAddingElementIntoHashSet, timeAddingElementIntoTreeSet);

		//Get from Sets
		double timeGettingElementInHashSet = hashSetExample.countTimeGettingElement(scan);
		double timeGettingElementInTreeSet = treeSetExample.countTimeGettingElement(scan);
		setTimeComparison.compareTimeGettingElement(timeGettingElementInHashSet, timeGettingElementInTreeSet);

		//Remove in Sets
		double timeRemovingElementInHashSet = hashSetExample.countTimeRemovingElement(scan);
		double timeRemovingElementInTreeSet = treeSetExample.countTimeRemovingElement(scan);
		setTimeComparison.compareTimeRemovingElement(timeRemovingElementInHashSet, timeRemovingElementInTreeSet);






	}
}
