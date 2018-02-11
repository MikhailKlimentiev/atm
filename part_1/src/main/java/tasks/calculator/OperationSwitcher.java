package tasks.calculator;

import java.util.Scanner;

/**
 * OperationSwitcher.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/11/2018
 */
public class OperationSwitcher {
	String operation;

	/**
	 * OperationSwitcher.
	 * This method is a constructor
	 */
	public OperationSwitcher() {

	}

	/**
	 * switchOperation.
	 * This method takes symbol from the console and according to the symbol selects appropriate operation
	 */
	public void switchOperation() {
		OperationsSet operationsSet = new OperationsSet();

		System.out.println("The calculator can do the following operations: ");
		System.out.println("a. 'add'");
		System.out.println("b. 'subtract'");
		System.out.println("c. 'multiply'");
		System.out.println("d. 'divide'");
		System.out.print("To select an operation please enter the appropriate letter and press Enter: ");

		Scanner scan = new Scanner(System.in);
		this.operation = scan.nextLine();
		switch (this.operation) {
			case "a": {
				operationsSet.add();
				break;
			}
			case "b": {
				operationsSet.subtract();
				break;
			}
			case "c": {
				operationsSet.multiply();
				break;
			}
			case "d": {
				operationsSet.divide();
				break;
			}
			default: {
				System.out.println("Unfortunately you have typed invalid symbol");
			}
		}
	}
}
