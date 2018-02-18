package tasks.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.random;
import static java.lang.String.format;

public class ArrayListExample {
	private List<Integer> arrayListExample;

	public ArrayListExample(){
		List<Integer> arrayListExample = new ArrayList<Integer>();
	}

	public void setArrayList(Scanner scan) {
		System.out.println("Please input size of the ArrayList: ");
		int arrayListSize = scan.nextInt();

		for (int i = 0; i < arrayListSize; i++) {
			this.arrayListExample.add((int)random()*15);
		}
	}

	public List<Integer> getArrayList() {
		return this.arrayListExample;
	}

	public void getAllArrayListElements(){
		System.out.println("The ArrayList elements: ");
		for (Integer element : arrayListExample) {
			int index = 0;
			System.out.println(format("%d: %d", index, element));
			index++;
		}
	}

	public void getArrayListElementByIndex(Scanner scan){
		int index = scan.nextInt();
		System.out.println(format("%d-th element of the arrayListExample: %d", index, arrayListExample.get(index)));
	}

	public void removeArrayListElementByIndex(Scanner scan){
		int index = scan.nextInt();
		System.out.println(format("%d-th element of the arrayListExample %d has been removed", index, arrayListExample.remove(index)));
	}
}
