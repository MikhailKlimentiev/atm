package tasks.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		//Sedan's objects
		Vehicle bmw3Series = new Sedan("Sedan","BMW 3 series", "Automatic", 8.00,
				40250, 5, 2013);
		Vehicle bmw4Series = new Sedan("Sedan","BMW 4 Series Gran Coupe", "Automatic",
				8.71, 43300, 5, 2015);
		Vehicle jaguar = new Sedan("Sedan", "Jaguar X-Type", "Automatic", 13.07,
				35060, 5, 2008);
		Vehicle mercedesBenzC43 = new Sedan("Sedan", "Mercedes-Benz C43", "Manual",
				12.0, 10000, 5, 2010);


		List<Vehicle> autopark = new ArrayList();
		autopark.add(bmw3Series);
		autopark.add(bmw4Series);
		autopark.add(jaguar);
		autopark.add(mercedesBenzC43);



//		TaxiStation taxiStation = new TaxiStation();
//		taxiStation.searchCarByParameters(autopark, scan);
//
//		TaxiStation taxiStation = new TaxiStation();
//		taxiStation.calculateCost(autopark);
//
//		Collections.sort(autopark, new FuelConsumptionComparator());
//		System.out.println("Order of cars in the Taxi Station on fuel consumption :");
//		for (Vehicle car : autopark) {
//			car.drive();
//		}
//
//		taxiStation.printAllCars(autopark);








	}
}
