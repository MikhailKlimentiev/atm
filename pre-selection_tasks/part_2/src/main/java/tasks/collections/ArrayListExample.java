package tasks.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.String.format;

/**
 * ArrayListExample.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public class ArrayListExample implements Insertable, Printable, Derivable, Removable {

	private List<Integer> arrayListExample;

	/**
	 * ArrayListExample.
	 * ArrayListExample() method is a constructor
	 *
	 * @param capacity
	 */
	public ArrayListExample(int capacity) {
		this.arrayListExample = new ArrayList<Integer>();
		for (int i = 0; i < capacity; i++) {
			this.arrayListExample.add((new Random().nextInt()));
		}
	}

	/**
	 * printAllElements.
	 * printAllElements() method prints in console all elements of ArrayList
	 */
	@Override
	public void printAllElements() {
		System.out.println("\nThe ArrayList elements: ");
		int index = 0;
		for (Integer element : this.arrayListExample) {
			System.out.println(format("%d: %d", index, element));
			index++;
		}
	}

	/**
	 * countTimeAddingElement.
	 * countTimeAddingElement() method counts time of adding an element into ArrayList
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeAddingElement(Scanner scan) {
		System.out.print("\nPlease input Integer element to add into the arrayListExample: ");
		int element = scan.nextInt();
		double startTime = System.nanoTime();
		this.arrayListExample.add(element);
		double endTime = System.nanoTime();
		System.out.println(format("The element %d has been successfully added into the arrayListExample.", element));
		return endTime - startTime;
	}

	/**
	 * countTimeGettingElement.
	 * countTimeGettingElement() method counts time of getting an element from ArrayList
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeGettingElement(Scanner scan) {
		System.out.print("\nPlease input an index of the arrayListExample element to show: ");
		int index = scan.nextInt();
		double startTime = System.nanoTime();
		if (index >= 0 && index <= this.arrayListExample.size() - 1) {
			System.out.println(format("%d-th element of the arrayListExample: %d.",
					index, this.arrayListExample.get(index)));
		} else System.out.println("You have typed incorrect index.");
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

	/**
	 * countTimeRemovingElement.
	 * countTimeRemovingElement() method counts time of removing an element in ArrayList
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeRemovingElement(Scanner scan) {
		System.out.print("\nPlease input an index of the arrayListExample element to remove: ");
		int index = scan.nextInt();
		double startTime = System.nanoTime();
		if (index >= 0 && index <= this.arrayListExample.size() - 1) {
			System.out.println(format("%d-th element of the arrayListExample %d has been removed.",
					index, this.arrayListExample.remove(index)));
		} else System.out.println("You have typed incorrect index.");
		double endTime = System.nanoTime();
		return endTime - startTime;
	}
}