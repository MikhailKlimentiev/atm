package tasks.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaxiStation {

	List<Vehicle> taxiStation = new ArrayList();

	public void calculateCost(List<Vehicle> taxiStation) {
		int sumCostOfVehicles = 0;
		for (Vehicle vehicle : taxiStation) {
			int vehicleCost = vehicle.getCost();
			sumCostOfVehicles = sumCostOfVehicles + vehicleCost;
		}
		System.out.println("Cost of the vehicle fleet is " + sumCostOfVehicles);
	}

	public void searchCarByParameters(List<Vehicle> taxiStation, Scanner scan) {
		System.out.print("Please input type of a car: ");
		String carType = scan.next();
		scan.nextLine();
		System.out.print("Please input model of a car: ");
		String carModel = scan.nextLine();
		System.out.print("Please input transmission type of a car: ");
		String carTransmissionType = scan.next();
		System.out.print("Please input minimum year of manufacture of a car: ");
		int yearOfManufacture = scan.nextInt();

		List<Vehicle> suitableCars = new ArrayList();
		int count = 0;
		for (Vehicle vehicle : taxiStation) {
			if (carType.equals(vehicle.getType())) {
				if (carModel.equals(vehicle.getModel())) {
					if (carTransmissionType.equals(vehicle.getTransmission())) {
						if (yearOfManufacture <= vehicle.getYearOfManufacture())
							suitableCars.add(vehicle);
					} else {
						break;
					}
				} else {
					break;
				}
			} else {
				break;
			}
		}
		if (suitableCars.size() != 0) {
			System.out.println("The cars below are suitable for you: ");
			for (Vehicle suitableCar : suitableCars) {
				System.out.print(++count + ". ");
				suitableCar.drive();
			}
		} else {
			System.out.println("Unfortunately there is no a car with such parameters");
		}
	}
}