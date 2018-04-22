package tasks.calculator;

import java.util.Scanner;

/**
 * OperationSwitcher.
 *
 * @author Mikhail Klimentsyeu
 * @version 3.0
 * @since 04/22/2018
 */
public class OperationSwitcher {
    double result = 0;

    public double switchOperation(Scanner scan, boolean condition) {
        double firstNumber;
        double secondNumber;
        int operation;

        System.out.println("\nPlease input first number: ");
        if (scan.hasNextDouble()) {
            firstNumber = scan.nextDouble();
        } else {
            scan.next();
            System.err.println("You inputted not a number. Please try again.");
            return 0;
        }

        System.out.println("Please input second number: ");
        if (scan.hasNextDouble()) {
            secondNumber = scan.nextDouble();
        } else {
            scan.next();
            System.err.println("You inputted not a number. Please try again.");
            return 0;
        }

        System.out.println("Please select the operation below:\n1. - Add\n2. - Subtract\n3. - Multiply\n4. - Divide\n0. - Exit");
        if (scan.hasNextInt()) {
            operation = scan.nextInt();

            switch (operation) {
                case 1: {
                    result = firstNumber + secondNumber;
                    break;
                }
                case 2: {
                    result = firstNumber - secondNumber;
                    break;
                }
                case 3: {
                    result = firstNumber * secondNumber;
                    break;
                }
                case 4: {
                    result = firstNumber / secondNumber;
                    break;
                }
                case 0: {
                    System.out.println("Completed.");
                    condition = false;
                    break;
                }
                default: {
                    System.err.println("You inputted not value number. Please try again.");
                }
            }
        } else {
            scan.next();
            System.err.println("You inputted not a number. Please try again.");
        }
        return result;
    }
}