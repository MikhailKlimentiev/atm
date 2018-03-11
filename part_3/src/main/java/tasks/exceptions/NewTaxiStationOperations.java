package tasks.exceptions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * TaxiStationOperations.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 03/11/2018
 */
public class NewTaxiStationOperations {

	public String searchCarType(List<Vehicle> taxiStation, Scanner scan) {

		String carType = "Not selected";

		boolean correctMenuInput = true;

		while (correctMenuInput) {
			try {
				System.out.println("\nPlease input a number of car's type: \n1. Sedan\n2. Cabriolet\n3. Crossover" +
						"\n4. Truck\n5. Exit");
				correctMenuInput = false;

				int input = scan.nextInt();

				if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5) {
					throw new MenuSymbolInputException("Car Type input");
				}

				switch (input) {
					case 1: {
						carType = "Sedan";
						break;
					}
					case 2: {
						carType = "Cabriolet";
						break;
					}
					case 3: {
						carType = "Crossover";
						break;
					}
					case 4: {
						carType = "Truck";
						break;
					}
					case 5: {
						return carType;
					}
				}
			} catch (MenuSymbolInputException msie) {
				correctMenuInput = true;
				System.err.println("Invalid Input. Please input a number from the list");
			} catch (InputMismatchException ime) {
				correctMenuInput = true;
				System.err.println("Invalid Input. Instead String please input a number from the list");
				scan.next();
			}
		}
		return carType;
	}

	public String searchCarModel(List<Vehicle> taxiStation, Scanner scan) {
		System.out.println("Please input a number of car's type: \n1. BMW\n2. Jaguar\n3. Mercedes-Benz\n4. Audi" +
				"\n5. Jeep" + "\n6. Volkswagen" + "\n7. Chevrolet" + "\n8. Exit");

		String carModel = "Not selected";
		boolean correctMenuInput = true;

		while (correctMenuInput) {
			try {
				int input = scan.nextInt();

				if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5 &&
						input != 6 && input != 7 && input != 8) {
					throw new MenuSymbolInputException("Car Model input");
				}
				correctMenuInput = false;

				switch (input) {
					case 1: {
						carModel = "BMW";
						break;
					}
					case 2: {
						carModel = "Jaguar";
						break;
					}
					case 3: {
						carModel = "Mercedes-Benz";
						break;
					}
					case 4: {
						carModel = "Audi";
						break;
					}
					case 5: {
						carModel = "Jeep";
						break;
					}
					case 6: {
						carModel = "Volkswagen";
						break;
					}
					case 7: {
						carModel = "Chevrolet";
						break;
					}
					case 8: {
						return carModel;
					}
				}
			} catch (MenuSymbolInputException msie) {
				correctMenuInput = true;
				msie.warn();
			} catch (InputMismatchException ime) {
				correctMenuInput = true;
				System.err.println("Invalid Input. Instead String please input a number from the list");
				scan.next();
			}
		}
		return carModel;
	}

	public String searchCarTransmissionType(List<Vehicle> taxiStation, Scanner scan) {
		System.out.println("Please input transmission type of a car: \n1. Automatic\n2. Manual\n3. Exit");

		String carTransmissionType = "Not selected";
		boolean correctMenuInput = true;

		while (correctMenuInput) {
			try {
				int input = scan.nextInt();

				if (input != 1 && input != 2 && input != 3) {
					throw new MenuSymbolInputException("Transmission type input");
				}
				correctMenuInput = false;

				switch (input) {
					case 1: {
						carTransmissionType = "Automatic";
						break;
					}
					case 2: {
						carTransmissionType = "Manual";
						break;
					}
					case 3: {
						return carTransmissionType;
					}
				}
			} catch (MenuSymbolInputException msie) {
				correctMenuInput = true;
				msie.warn();
			} catch (InputMismatchException ime) {
				correctMenuInput = true;
				System.err.println("Invalid Input. Instead String please input a number from the list");
				scan.next();
			}
		}
		return carTransmissionType;
	}

	public int searchCarManufactureYear(List<Vehicle> taxiStation, Scanner scan) {

		System.out.print("Please input minimum year of manufacture of a car: ");

		boolean correctMenuInput = true;
		int yearOfManufacture = 0;

		while (correctMenuInput) {
			try {

				yearOfManufacture = scan.nextInt();
				correctMenuInput = false;

			} catch (InputMismatchException ime) {
				correctMenuInput = true;
				System.err.println("Invalid Input. Instead String please input a number from the list");
				scan.next();
			}
		}
		return yearOfManufacture;
	}

	public String searchCarColor(List<Vehicle> taxiStation, Scanner scan) {
		System.out.println("Please input transmission type of a car: \n1. White\n2. Black\n3. Yellow\n4. Blue" +
				"\n5. Exit");

		String carColor = "Not selected";
		boolean correctMenuInput = true;

		while (correctMenuInput) {
			try {
				int input = scan.nextInt();

				if (input != 1 && input != 2 && input != 3 && input != 4 && input != 5) {
					throw new MenuSymbolInputException("Color input");
				}
				correctMenuInput = false;

				switch (input) {
					case 1: {
						carColor = "White";
						break;
					}
					case 2: {
						carColor = "Black";
						break;
					}
					case 3: {
						carColor = "Yellow";
						break;
					}
					case 4: {
						carColor = "Blue";
						break;
					}
					case 5: {
						return carColor;
					}
				}
			} catch (MenuSymbolInputException msie) {
				correctMenuInput = true;
				msie.warn();
			} catch (InputMismatchException ime) {
				correctMenuInput = true;
				System.err.println("Invalid Input. Instead String please input a number from the list");
				scan.next();
			}
		}
		return carColor;
	}

	public void searchCarByParameters(List<Vehicle> taxiStation, String carType, String carModel,
	                                  String carTransmissionType, String carColor, int yearOfManufacture) {
		List<Vehicle> suitableCars = new ArrayList();
		int count = 0;
		for (Vehicle vehicle : taxiStation) {
			if (carType.equals(vehicle.getType())) {
				if (vehicle.getModel().contains(carModel)) {
					if (carTransmissionType.equals(vehicle.getTransmission())) {
						if (yearOfManufacture <= vehicle.getYearOfManufacture()) {
							if (carColor.equals(vehicle.getColor()))
								suitableCars.add(vehicle);
						} else {
							continue;
						}
					} else {
						continue;
					}
				} else {
					continue;
				}
			} else {
				continue;
			}
		}
		if (suitableCars.size() != 0) {
			System.out.println("\nThe cars below are suitable for you: ");
			for (Vehicle suitableCar : suitableCars) {
				System.out.print(++count + ". ");
				suitableCar.drive();
			}
		} else {
			System.out.println("\nUnfortunately there is no any cars with such parameters");
		}
	}
}