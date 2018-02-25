package tasks.collections;

import java.util.*;

import static java.lang.String.format;

/**
 * TreeMapExample.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public class TreeMapExample implements Printable, Insertable, Derivable, Removable {

	private Map<Integer, String> treeMapExample;

	/**
	 * TreeMapExample.
	 * TreeMapExample() method is a constructor
	 *
	 * @param capacity
	 */
	public TreeMapExample(int capacity) {
		this.treeMapExample = new TreeMap<Integer, String>();
		for (int i = 0; i < capacity; i++) {
			this.treeMapExample.put(i, format("%s", new Random().nextFloat()));
		}
	}

	/**
	 * printAllElements.
	 * printAllElements() method prints in console all elements of TreeMap
	 */
	@Override
	public void printAllElements() {
		System.out.println("\nThe TreeMapExample elements: ");
		for (Map.Entry<Integer, String> pair : treeMapExample.entrySet()) {
			System.out.println(format("%d: %s", pair.getKey(), pair.getValue()));
		}
	}

	/**
	 * countTimeAddingElement.
	 * countTimeAddingElement() method counts time of adding an element into TreeMap
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeAddingElement(Scanner scan) {
		System.out.print("\nPlease input Integer element's key to add into the treeMapExample: ");
		Integer key = scan.nextInt();
		System.out.print("\nPlease input String element's value to add into the treeMapExample: ");
		String value = scan.next();
		double startTime = System.nanoTime();
		this.treeMapExample.put(key, value);
		double endTime = System.nanoTime();
		System.out.println(format("\nThe key %d and the value '%s' has been successfully added into the the treeMapExample",
				key, value));
		return endTime - startTime;
	}

	/**
	 * countTimeGettingElement.
	 * countTimeGettingElement() method counts time of getting an element from TreeMap
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeGettingElement(Scanner scan) {
		System.out.print("\nPlease input Integer key of the treeMapExample element to show: ");
		Integer key = scan.nextInt();
		double startTime = System.nanoTime();
		if (key >= 0 && key <= this.treeMapExample.size() - 1) {
			System.out.println(format("\nKey: %d Value: '%s' of the treeMapExample", key, this.treeMapExample.get(key)));
		} else {
			System.out.println("\nYou have typed incorrect index");
		}
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

	/**
	 * countTimeRemovingElement.
	 * countTimeRemovingElement() method counts time of removing an element in TreeMap
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeRemovingElement(Scanner scan) {
		System.out.print("\nPlease input Integer key of the treeMapExample element to remove: ");
		Integer key = scan.nextInt();
		double startTime = System.nanoTime();
		if (key >= 0 && key <= this.treeMapExample.size() - 1) {
			System.out.println(format("\nKey: %d Value: '%s' of the treeMapExample has been removed",
					key, this.treeMapExample.remove(key)));
		} else {
			System.out.println("\nYou have typed incorrect index");
		}
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

}
