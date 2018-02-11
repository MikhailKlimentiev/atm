package tasks.calculator;

import java.util.Scanner;

/**
 * OperationsSet.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 02/11/2018
 */
public class OperationsSet {
	private float firstNumber;
	private float secondNumber;

	/**
	 * OperationsSet.
	 * This method is a constructor
	 */
	public OperationsSet() {

	}

	/**
	 * add.
	 * This method takes numbers from the console, adds them and prints the result to the console
	 */
	public void add() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input first number and press Enter: ");
		this.firstNumber = scan.nextFloat();
		System.out.print("Please input second number and press Enter: ");
		this.secondNumber = scan.nextFloat();
		System.out.println("Sum is: " + (this.firstNumber + this.secondNumber));
	}

	/**
	 * subtract.
	 * This method takes numbers from the console, subtracts them and prints the result to the console
	 */
	public void subtract() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input first number and press Enter: ");
		this.firstNumber = scan.nextFloat();
		System.out.print("Please input second number and press Enter: ");
		this.secondNumber = scan.nextFloat();
		System.out.println("Sum is: " + (this.firstNumber - this.secondNumber));
	}

	/**
	 * multiply.
	 * This method takes numbers from the console, multiplies them and prints the result to the console
	 */
	public void multiply() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input first number and press Enter: ");
		this.firstNumber = scan.nextFloat();
		System.out.print("Please input second number and press Enter: ");
		this.secondNumber = scan.nextFloat();
		System.out.println("Sum is: " + (this.firstNumber * this.secondNumber));
	}

	/**
	 * divide.
	 * This method takes numbers from the console, divides them and prints the result to the console
	 */
	public void divide() {
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input first number and press Enter: ");
		this.firstNumber = scan.nextFloat();
		System.out.print("Please input second number and press Enter: ");
		this.secondNumber = scan.nextFloat();
		System.out.println("Sum is: " + (this.firstNumber / this.secondNumber));
	}
}