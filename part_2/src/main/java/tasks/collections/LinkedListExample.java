package tasks.collections;

import java.util.*;

import static java.lang.String.format;

/**
 * LinkedListExample.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public class LinkedListExample implements Insertable, Printable, Derivable, Removable {

	private List<Integer> linkedListExample;

	/**
	 * LinkedListExample.
	 * LinkedListExample() method is a constructor
	 *
	 * @param capacity
	 */
	public LinkedListExample(int capacity) {
		this.linkedListExample = new LinkedList<Integer>();
		for (int i = 0; i < capacity; i++) {
			this.linkedListExample.add((new Random().nextInt()));
		}
	}

	/**
	 * printAllElements.
	 * printAllElements() method prints in console all elements of a collection
	 */
	@Override
	public void printAllElements() {
		System.out.println("\nThe LinkedList elements: ");
		int index = 0;
		for (Integer element : this.linkedListExample) {
			System.out.println(format("%d: %d", index, element));
			index++;
		}
	}

	/**
	 * countTimeAddingElement.
	 * countTimeAddingElement() method counts time of adding an element into collection
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeAddingElement(Scanner scan) {
		System.out.print("\nPlease input Integer element to add into the linkedListExample: ");
		int element = scan.nextInt();
		double startTime = System.nanoTime();
		this.linkedListExample.add(element);
		double endTime = System.nanoTime();
		System.out.println(format("\nThe element %d has been successfully added into the linkedListExample", element));
		return endTime - startTime;
	}

	/**
	 * countTimeGettingElement.
	 * countTimeGettingElement() method counts time of getting an element from collection
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeGettingElement(Scanner scan) {
		System.out.print("\nPlease input an index of the linkedListExample element to show: ");
		int index = scan.nextInt();
		double startTime = System.nanoTime();
		if (index >= 0 && index <= this.linkedListExample.size() - 1) {
			System.out.println(format("\n%d-th element of the linkedListExample: %d",
					index, this.linkedListExample.get(index)));
		} else System.out.println("\nYou have typed incorrect index");
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

	/**
	 * countTimeRemovingElement.
	 * countTimeRemovingElement() method counts time of removing an element in collection
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeRemovingElement(Scanner scan) {
		System.out.print("\nPlease input an index of the linkedListExample element to remove: ");
		int index = scan.nextInt();
		double startTime = System.nanoTime();
		if (index >= 0 && index <= this.linkedListExample.size() - 1) {
			System.out.println(format("\n%d-th element of the linkedListExample %d has been removed",
					index, this.linkedListExample.remove(index)));
		} else System.out.println("\nYou have typed incorrect index");
		double endTime = System.nanoTime();
		return endTime - startTime;
	}
}
