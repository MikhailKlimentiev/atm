package tasks.collections;

import java.util.*;

import static java.lang.String.format;

/**
 * HashMapExample.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public class HashMapExample implements Printable, Insertable, Derivable, Removable {

	private Map<Integer, String> hashMapExample;

	/**
	 * HashMapExample.
	 * HashMapExample() method is a constructor
	 *
	 * @param capacity
	 */
	public HashMapExample(int capacity) {
		this.hashMapExample = new HashMap<Integer, String>();
		for (int i = 0; i < capacity; i++) {
			this.hashMapExample.put(i, format("%s", new Random().nextFloat()));
		}
	}

	/**
	 * printAllElements.
	 * printAllElements() method prints in console all elements of HashMap
	 */
	@Override
	public void printAllElements() {
		System.out.println("\nThe HashMap elements: ");
		for (Map.Entry<Integer, String> pair : hashMapExample.entrySet()) {
			System.out.println(format("%d: %s", pair.getKey(), pair.getValue()));
		}
	}

	/**
	 * countTimeAddingElement.
	 * countTimeAddingElement() method counts time of adding an element into HashMap
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeAddingElement(Scanner scan) {
		System.out.print("\nPlease input Integer element's key to add into the hashMapExample: ");
		Integer key = scan.nextInt();
		System.out.print("\nPlease input String element's value to add into the hashMapExample: ");
		String value = scan.next();
		double startTime = System.nanoTime();
		this.hashMapExample.put(key, value);
		double endTime = System.nanoTime();
		System.out.println(format("\nThe key %d and the value '%s' has been successfully added into the the hashMapExample",
				key, value));
		return endTime - startTime;
	}

	/**
	 * countTimeGettingElement.
	 * countTimeGettingElement() method counts time of getting an element from HashMap
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeGettingElement(Scanner scan) {
		System.out.print("\nPlease input Integer key of the hashMapExample element to show: ");
		Integer key = scan.nextInt();
		double startTime = System.nanoTime();
		if (key >= 0 && key <= this.hashMapExample.size() - 1) {
			System.out.println(format("\nKey: %d Value: '%s' of the hashMapExample", key, this.hashMapExample.get(key)));
		} else {
			System.out.println("\nYou have typed incorrect index");
		}
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

	/**
	 * countTimeRemovingElement.
	 * countTimeRemovingElement() method counts time of removing an element in HashMap
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeRemovingElement(Scanner scan) {
		System.out.print("\nPlease input Integer key of the hashMapExample element to remove: ");
		Integer key = scan.nextInt();
		double startTime = System.nanoTime();
		if (key >= 0 && key <= this.hashMapExample.size() - 1) {
			System.out.println(format("\nKey: %d Value: %s of the hashMapExample has been removed",
					key, this.hashMapExample.remove(key)));
		} else {
			System.out.println("\nYou have typed incorrect index");
		}
		double endTime = System.nanoTime();
		return endTime - startTime;
	}
}