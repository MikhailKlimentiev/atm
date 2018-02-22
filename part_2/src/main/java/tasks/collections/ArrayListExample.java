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
 * @version 1.0
 * @since 02/22/2018
 */
public class ArrayListExample {
	private List<Integer> arrayListExample;

	/**
	 * ArrayListExample.
	 * The method ArrayListExample(int capacity) is a constructor
	 * @param capacity
	 */
	public ArrayListExample(int capacity) {
		this.arrayListExample = new ArrayList<Integer>(capacity);
		for (int i = 0; i < capacity; i++) {
			this.arrayListExample.add((new Random().nextInt()));
		}
	}

	/**
	 * getAllArrayListElements.
	 * The method getAllArrayListElements() prints ArrayList elements in console
	 */
	public void getAllArrayListElements(){
		System.out.println("\nThe ArrayList elements: ");
		int index = 0;
		for (Integer element : this.arrayListExample) {
			System.out.println(format("%d: %d", index, element));
			index++;
		}
	}

	/**
	 * addElementIntoArrayList.
	 * The method addElementIntoArrayList(Scanner scan) counts adding elements time into ArrayList
	 * @param scan
	 * @return double (endTime - startTime)
	 */
	public double addElementIntoArrayList(Scanner scan){
		System.out.print("\nPlease input an Integer element to add into the arrayListExample: ");
		int element = scan.nextInt();
		double startTime = System.nanoTime();
		this.arrayListExample.add(element);
		double endTime = System.nanoTime();
		System.out.println(format("\nThe element %d has been successfully added into the the arrayListExample", element));
		return endTime - startTime;
	}

	/**
	 * getArrayListElementByIndex.
	 * The method getArrayListElementByIndex(Scanner scan) counts getting elements time from ArrayList
	 * @param scan
	 * @return double (endTime - startTime)
	 */
	public double getArrayListElementByIndex(Scanner scan){
		System.out.print("\nPlease input an index of the arrayListExample element to show: ");
		int index = scan.nextInt();
		double startTime = System.nanoTime();
		if (index >= 0 && index <= this.arrayListExample.size() - 1) {
			System.out.println(format("\n%d-th element of the arrayListExample: %d",
					index, this.arrayListExample.get(index)));
		} else System.out.println("\nYou have typed incorrect index");
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

	/**
	 * removeArrayListElementByIndex.
	 * The method removeArrayListElementByIndex(Scanner scan) counts removing elements time into ArrayList
	 * @param scan
	 * @return double (endTime - startTime)
	 */
	public double removeArrayListElementByIndex(Scanner scan){
		System.out.print("\nPlease input an index of the arrayListExample element to remove: ");
		int index = scan.nextInt();
		double startTime = System.nanoTime();
		if (index >= 0 && index <= this.arrayListExample.size() - 1) {
			System.out.println(format("\n%d-th element of the arrayListExample %d has been removed",
					index, this.arrayListExample.remove(index)));
		} else System.out.println("\nYou have typed incorrect index");
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

}