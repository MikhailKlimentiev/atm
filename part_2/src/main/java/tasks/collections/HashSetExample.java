package tasks.collections;

import java.util.*;

import static java.lang.String.format;

/**
 * HashSetExample.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/24/2018
 */
public class HashSetExample implements Insertable, Printable, Derivable, Removable {

	private Set<String> hashSetExample;

	/**
	 * HashSetExample.
	 * HashSetExample() method is a constructor
	 *
	 * @param capacity
	 */
	public HashSetExample(int capacity) {
		this.hashSetExample = new HashSet<String>();
		for (int i = 0; i < capacity; i++) {
			this.hashSetExample.add(format("%s", new Random().nextFloat()));
		}
	}

	/**
	 * printAllElements.
	 * printAllElements() method prints in console all elements of HashSet
	 */
	@Override
	public void printAllElements() {
		System.out.println("\nThe HashSet elements: ");
		int index = 0;
		for (String element : this.hashSetExample) {
			System.out.println(format("%d: %s", index, element));
			index++;
		}
	}

	/**
	 * countTimeAddingElement.
	 * countTimeAddingElement() method counts time of adding an element into HashSet
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeAddingElement(Scanner scan) {
		System.out.print("\nPlease input String element to add into the hashSetExample: ");
		String element = scan.nextLine();
		double startTime = System.nanoTime();
		this.hashSetExample.add(element);
		double endTime = System.nanoTime();
		System.out.println(format("\nThe element %s has been successfully added into the hashSetExample", element));
		return endTime - startTime;
	}

	/**
	 * countTimeGettingElement.
	 * countTimeGettingElement() method counts time of getting an element from HashSet
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeGettingElement(Scanner scan) {
		System.out.print("\nPlease input an index of the hashSetExample element to show: ");
		int indexFromUser = scan.nextInt();
		double startTime = System.nanoTime();
		Iterator iterator = hashSetExample.iterator();
		for (int index = 0; iterator.hasNext(); index++, iterator.next()) {
			if (indexFromUser >= 0 && indexFromUser <= this.hashSetExample.size() - 1) {
				if (index == indexFromUser) {
					System.out.println(format("\n%d-th element of the hashSetExample: %s", index, iterator.next()));
					break;
				}
			} else {
				System.out.println("\nYou have typed incorrect index");
				break;
			}
		}
		double endTime = System.nanoTime();
		return endTime - startTime;
	}

	/**
	 * countTimeRemovingElement.
	 * countTimeRemovingElement() method counts time of removing an element in HashSet
	 *
	 * @param scan
	 * @return (endTime - startTime)
	 */
	@Override
	public double countTimeRemovingElement(Scanner scan) {
		System.out.print("\nPlease input an index of the hashSetExample element to remove: ");
		int indexFromUser = scan.nextInt();
		double startTime = System.nanoTime();
		Iterator iterator = hashSetExample.iterator();
		for (int index = 0; iterator.hasNext(); index++, iterator.next()) {
			if (indexFromUser >= 0 && indexFromUser <= this.hashSetExample.size() - 1) {
				if (index == indexFromUser) {
					String elementToRemove = (String) iterator.next();
					System.out.println(format("\n%d-th element of the hashSetExample %s has been removed", index,
							elementToRemove, hashSetExample.remove(elementToRemove)));
					break;
				}
			} else {
				System.out.println("\nYou have typed incorrect index");
				break;
			}
		}
		double endTime = System.nanoTime();
		return endTime - startTime;
	}
}






