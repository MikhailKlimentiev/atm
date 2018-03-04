package tasks.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Vehicle bmw3Series = new Sedan("Sedan","BMW", "Automatic", 8.71, 40250, 5);
		bmw3Series.getNumberOfSeats();
		bmw3Series.getLpk();
		bmw3Series.getTransmission();
		bmw3Series.getModel();
		bmw3Series.getCost();
		bmw3Series.getType();
		bmw3Series.inform();
		bmw3Series.drive();

		List<Vehicle> autopark = new ArrayList();
		autopark.add(bmw3Series);

		TaxiStation taxiStation = new TaxiStation();
		taxiStation.searchCarByParameters(autopark, scan);








	}
}
