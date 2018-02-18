package tasks.collections;

import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		ArrayListExample arrayListExample = new ArrayListExample();
		Scanner scan = new Scanner(System.in);

		arrayListExample.setArrayList(scan);
		arrayListExample.getAllArrayListElements();
		arrayListExample.getArrayList();
		arrayListExample.getArrayListElementByIndex(scan);
		arrayListExample.getAllArrayListElements();
		arrayListExample.removeArrayListElementByIndex(scan);
		arrayListExample.getAllArrayListElements();
	}
}
