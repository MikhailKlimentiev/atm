package tasks.exceptions;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * TaxiStationOperations.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/09/2018
 */
public class TaxiStationOperations {

	/**
	 * calculateCost.
	 * calculateCost() method gets collection of cars, calculates cost of all collecton's objects and prints
	 * result in console
	 *
	 * @param taxiStation
	 */
	public void calculateCost(List<Vehicle> taxiStation) {
		int sumCostOfVehicles = 0;
		for (Vehicle vehicle : taxiStation) {
			int vehicleCost = vehicle.getCost();
			sumCostOfVehicles = sumCostOfVehicles + vehicleCost;
		}
		System.out.println("\nCost of the Taxi Station is " + sumCostOfVehicles + "$");
	}

	/**
	 * searchCarByParameters.
	 * searchCarByParameters() method gets collection of cars, gets values of car type, car model, transmission type,
	 * minimum year of car's manufacture from console, finds appropriate car's objects by getting parameters,
	 * creates collection with these objects and prints all these selected objects in console.
	 *
	 * @param taxiStation
	 * @param scan
	 */
	public void searchCarByParameters(List<Vehicle> taxiStation, Scanner scan) {
		System.out.println("\nPlease select an appropriate car by car's type, car's brand, transmission type and minimum " +
				"year of car's manufacture");
		boolean condition = true;
		String carType = null;
		String carModel = null;
		String carTransmissionType = null;
		int yearOfManufacture = 0;
		while (condition) {

			System.out.println("\nPlease input a number of car's type: \n1. Sedan\n2. Cabriolet\n3. Crossover\n4. Truck\n5. Exit");

			boolean correctMenuInput = true;
			int input;
			while (correctMenuInput) {
				try {
					correctMenuInput = false;

					input = scan.nextInt();

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
							return;
						}
					}
				} catch (MenuSymbolInputException msie) {
					correctMenuInput = true;
					System.err.println("Please input a number from the list");
				} catch (InputMismatchException ime) {
					correctMenuInput = true;
					System.err.println("msie");
					scan.next();
				}

			}

			System.out.println("Please input a number of car's type: \n1. BMW\n2. Jaguar\n3. Mercedes-Benz\n4. Audi" +
					"\n5. Jeep" + "\n6. Volkswagen" + "\n7. Chevrolet" + "\n8. Exit");

			correctMenuInput = true;
			while (correctMenuInput) {
				try {

					input = scan.nextInt();


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
							return;
						}
					}
				} catch (InputMismatchException ime) {
					System.out.println("Please input a number instead string");
				} catch (MenuSymbolInputException msie) {
					System.out.println("Please input a number from the list");
				}
			}

			System.out.println("Please input transmission type of a car: \n1. Automatic\n2. Manual\n3. Exit");

			correctMenuInput = true;
			while (correctMenuInput) {
				try {
					input = scan.nextInt();

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
							return;
						}
					}
				} catch (MenuSymbolInputException msie) {
					System.out.println("Please input a number from the list");
				} catch (InputMismatchException ime) {
					System.out.println("Please input a number instead string");

					return;
				}

			}

			System.out.print("Please input minimum year of manufacture of a car: ");

			correctMenuInput = true;
			while (correctMenuInput) {
				try {
					input = scan.nextInt();

					correctMenuInput = false;

					yearOfManufacture = scan.nextInt();

				} catch (InputMismatchException ime) {
					System.out.println("Please input a number instead string");
				}

				List<Vehicle> suitableCars = new ArrayList();
				int count = 0;
				for (Vehicle vehicle : taxiStation) {
					if (carType.equals(vehicle.getType())) {
						if (vehicle.getModel().contains(carModel)) {
							if (carTransmissionType.equals(vehicle.getTransmission())) {
								if (yearOfManufacture <= vehicle.getYearOfManufacture()) {
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
	}

	/**
	 * printAllCars.
	 * printAllCars() method gets collection of cars and prints all car's objects from this collection in console
	 *
	 * @param taxiStation
	 */
	public void printAllCars(List<Vehicle> taxiStation) {
		System.out.println("All cars of the Taxi Station: ");
		int count = 0;
		for (Vehicle car : taxiStation) {
			System.out.print(++count + ". ");
			car.drive();
		}
	}
}
