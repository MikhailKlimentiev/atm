package tasks.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.random;
import static java.lang.String.format;

public class ArrayListExample {
	private List<Integer> arrayListExample;

	public ArrayListExample(){
		this.arrayListExample = new ArrayList<Integer>();
	}

	public void setArrayList(Scanner scan) {

		System.out.print("Please input size of the ArrayList: ");
		int arrayListSize = scan.nextInt();

		for (int i = 0; i < arrayListSize; i++) {
			this.arrayListExample.add((new Random().nextInt()));
		}
	}

	public List<Integer> getArrayList() {
		return this.arrayListExample;
	}

	public void getAllArrayListElements(){
		System.out.println("The ArrayList elements: ");
		int index = 0;
		for (Integer element : this.arrayListExample) {
			System.out.println(format("%d: %d", index, element));
			index++;
		}
	}

	public void getArrayListElementByIndex(Scanner scan){
		System.out.print("Please input an index of the arrayListExample element to show: ");
		int index = scan.nextInt();
		System.out.println(format("%d-th element of the arrayListExample: %d",
				index, this.arrayListExample.get(index)));
	}

	public void removeArrayListElementByIndex(Scanner scan){
		System.out.print("Please input an index of the arrayListExample element to remove: ");
		int index = scan.nextInt();
		System.out.println(format("%d-th element of the arrayListExample %d has been removed",
				index, this.arrayListExample.remove(index)));
	}

}