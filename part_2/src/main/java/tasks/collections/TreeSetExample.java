package tasks.collections;

import java.util.*;

import static java.lang.String.format;

/**
 * TreeSetExample.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public class TreeSetExample implements Insertable, Printable, Derivable, Removable {

	private Set<String> treeSetExample;

	/**
	 * TreeSetExample.
	 * TreeSetExample() method is a constructor
	 *
	 * @param capacity
	 */
	public TreeSetExample(int capacity) {
		this.treeSetExample = new TreeSet<String>();
		for (int i = 0; i < capacity; i++) {
			this.treeSetExample.add(format("%s", new Random().nextFloat()));
		}
	}

	/**
	 * printAllElements.
	 * printAllElements() method prints in console all elements of TreeSet
	 */
	@Override
	public void printAllElements() {
		System.out.println("\nThe TreeSet elements: ");
		int index = 0;
		for (String element : this.treeSetExample) {
			System.out.println(format("%d: %s", index, element));
			index++;
		}
	}

	/**
	 * countTimeAddingElement.
	 * countTimeAddingElement() method counts time of adding an element into TreeSet
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeAddingElement(Scanner scan) {
		System.out.print("\nPlease input String element to add into the treeSetExample: ");
		String element = scan.next();
		double startTime = System.nanoTime();
		this.treeSetExample.add(element);
		double endTime = System.nanoTime();
		System.out.println(format("The element %s has been successfully added into the treeSetExample.", element));
		return endTime - startTime;
	}

	/**
	 * countTimeGettingElement.
	 * countTimeGettingElement() method counts time of getting an element from TreeSet
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeGettingElement(Scanner scan) {
		System.out.print("\nPlease input an index of the treeSetExample element to show: ");
		int indexFromUser = scan.nextInt();
		double startTime = System.nanoTime();
		Iterator iterator = treeSetExample.iterator();
		for (int index = 0; iterator.hasNext(); index++, iterator.next()) {
			if (indexFromUser >= 0 && indexFromUser <= this.treeSetExample.size() - 1) {
				if (index == indexFromUser) {
					System.out.println(format("%d-th element of the treeSetExample: %s", index, iterator.next()));
					break;
				}
			} else {
				System.out.println("You have typed incorrect index.");
				break;
			}
		}
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

	/**
	 * countTimeRemovingElement.
	 * countTimeRemovingElement() method counts time of removing an element in TreeSet
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeRemovingElement(Scanner scan) {
		System.out.print("\nPlease input an index of the treeSetExample element to remove: ");
		int indexFromUser = scan.nextInt();
		double startTime = System.nanoTime();
		Iterator iterator = treeSetExample.iterator();
		for (int index = 0; iterator.hasNext(); index++, iterator.next()) {
			if (indexFromUser >= 0 && indexFromUser <= this.treeSetExample.size() - 1) {
				if (index == indexFromUser) {
					String elementToRemove = (String) iterator.next();
					System.out.println(format("%d-th element of the treeSetExample %s has been removed.", index,
							elementToRemove, treeSetExample.remove(elementToRemove)));
					break;
				}
			} else {
				System.out.println("You have typed incorrect index.");
				break;
			}
		}
		double endTime = System.nanoTime();
		return endTime - startTime;
	}
}
