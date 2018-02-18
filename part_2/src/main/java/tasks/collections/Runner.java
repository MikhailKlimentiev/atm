package tasks.collections;

import java.util.Scanner;


public class Runner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayListExample arrayListExample = new ArrayListExample(10000);
//		arrayListExample.getAllArrayListElements();
		arrayListExample.addElementIntoArrayList(scan);
//		arrayListExample.getAllArrayListElements();
		arrayListExample.getArrayListElementByIndex(scan);
//		arrayListExample.getAllArrayListElements();
		arrayListExample.removeArrayListElementByIndex(scan);
//		arrayListExample.getAllArrayListElements();
	}
}
