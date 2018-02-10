package tasks.calculator;

import java.util.Scanner;

/**
 * OperationSwitcher.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 02/10/2018
 */
public class OperationSwitcher {
	String operation;

	/**
	 * switchOperation.
	 * This method takes symbol from the console and according to the symbol selects appropriate operation
	 */
	public void switchOperation() {
		Calculator calculator = new Calculator();

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
				calculator.add();
				break;
			}
			case "b": {
				calculator.subtract();
				break;
			}
			case "c": {
				calculator.multiply();
				break;
			}
			case "d": {
				calculator.divide();
				break;
			}
			default: {
				System.out.println("Unfortunately you have typed invalid symbol");
			}
		}
	}
}
