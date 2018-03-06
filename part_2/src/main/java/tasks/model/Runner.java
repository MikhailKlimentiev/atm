package tasks.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Vehicle bmw3Series = new Sedan("Sedan","BMW 3 series", "Automatic", 8.71,
				40250, 5, 2013);
		Vehicle bmw4Series = new Sedan("Sedan","BMW 3 series", "Automatic", 8.71,
				40350, 5, 2015);
		bmw3Series.getNumberOfSeats();
		bmw3Series.getLitresPerHudredKm();
		bmw3Series.getTransmission();
		bmw3Series.getModel();
		bmw3Series.getCost();
		bmw3Series.getType();
		bmw3Series.inform();
		bmw3Series.drive();

		List<Vehicle> autopark = new ArrayList();
		autopark.add(bmw3Series);
		autopark.add(bmw4Series);

		TaxiStation taxiStation = new TaxiStation();
		taxiStation.searchCarByParameters(autopark, scan);








	}
}
