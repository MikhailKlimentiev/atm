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
			sumCostOfVehicles = vehicleCost + vehicleCost;
		}
		System.out.println("Cost of the vehicle fleet is " + sumCostOfVehicles);
	}

	public void searchCarByParameters(List<Vehicle> taxiStation, Scanner scan) {
		System.out.println("Please input type of a car: ");
		String carType = scan.next();
		System.out.println("Please input model of a car: ");
		String carModel = scan.next();
		System.out.println("Please input transmission type of a car: ");
		String carTransmissionType = scan.next();

		List<Vehicle> suitableCars = new ArrayList();
		for (Vehicle vehicle : taxiStation) {
			if (carType.equals(vehicle.getType())) {
				if(carModel.equals(vehicle.getModel())) {
					if (carTransmissionType.equals(vehicle.getTransmission())) {
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
		if (suitableCars.size() == 0) {
			System.out.println("Unfortunately there is no a car with such parameters");
		} else {
			System.out.println("The cars below are suitable for you: ");
			int count = 0;
			for (Vehicle suitableCar : suitableCars) {
				System.out.println(count++);
				suitableCar.drive();
			}
		}
	}
}
