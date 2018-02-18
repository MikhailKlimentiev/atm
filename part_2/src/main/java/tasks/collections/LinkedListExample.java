package tasks.collections;

import java.util.*;

import static java.lang.String.format;

public class LinkedListExample {
	private List<Integer> linkedListExample;

	public LinkedListExample(int capacity) {
		this.linkedListExample = new LinkedList<Integer>();
		for (int i = 0; i < capacity; i++) {
			this.linkedListExample.add((new Random().nextInt()));
		}
	}

	public void getAllLinkedListElements(){
		System.out.println("\nThe LinkedList elements: ");
		int index = 0;
		for (Integer element : this.linkedListExample) {
			System.out.println(format("%d: %d", index, element));
			index++;
		}
	}

	public double addElementIntoLinkedList(Scanner scan){
		System.out.print("\nPlease input an Integer element to add into the linkedListExample: ");
		int element = scan.nextInt();
		double startTime = System.nanoTime();
		this.linkedListExample.add(element);
		double endTime = System.nanoTime();
		System.out.println(format("\nThe element %d has been successfully added into the the linkedListExample", element));
		return endTime - startTime;
	}

	public double getLinkedListElementByIndex(Scanner scan){
		System.out.print("\nPlease input an index of the linkedListExample element to show: ");
		int index = scan.nextInt();
		double startTime = System.nanoTime();
		if (index >= 0 && index <= this.linkedListExample.size() - 1) {
			System.out.println(format("\n%d-th element of the linkedListExample: %d",
					index, this.linkedListExample.get(index)));
		} else System.out.println("\nYou have types incorrect index");
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

	public double removeLinkedListElementByIndex(Scanner scan){
		System.out.print("\nPlease input an index of the linkedListExample element to remove: ");
		int index = scan.nextInt();
		double startTime = System.nanoTime();
		if (index >= 0 && index <= this.linkedListExample.size() - 1) {
			System.out.println(format("\n%d-th element of the linkedListExample %d has been removed",
					index, this.linkedListExample.remove(index)));
		} else System.out.println("\nYou have types incorrect index");
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

}