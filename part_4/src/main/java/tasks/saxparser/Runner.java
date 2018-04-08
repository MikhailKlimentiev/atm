package tasks.saxparser;

import tasks.database.CabrioletDatabaseReader;
import tasks.database.CrossoverDatabaseReader;
import tasks.database.SedanDatabaseReader;
import tasks.database.TruckDatabaseReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * Runner.
 *
 * @author Mikhail Klimentsyeu
 * @version 4.0
 * @since 04/08/2018
 */
public class Runner {


	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		List<Vehicle> taxiStation = new ArrayList();
		TaxiStationOperations TaxiStationOperations = new TaxiStationOperations();

		try {




// ------------------- search a car by parameters in the Taxi Station ---------------------
			boolean condition = true;
			System.out.println("\nPlease select an appropriate car by car's type, car's brand, " +
					"transmission type, color and minimum year of car's manufacture");
			while (condition) {
				String carType = TaxiStationOperations.searchCarType(scan);
				if (carType.equals("Not selected")) {
					break;
				}

				String carModel = TaxiStationOperations.searchCarModel(scan);
				if (carModel.equals("Not selected")) {
					break;
				}

				String carTransmissionType = TaxiStationOperations.searchCarTransmissionType(scan);
				if (carTransmissionType.equals("Not selected")) {
					break;
				}

				String carColor = TaxiStationOperations.searchCarColor(scan);
				if (carTransmissionType.equals("Not selected")) {
					break;
				}

				int сarManufactureYear = TaxiStationOperations.searchCarManufactureYear(scan);

				TaxiStationOperations.searchCarByParameters(taxiStation, carType, carModel, carTransmissionType,
						carColor, сarManufactureYear);
			}

//--------------- print all cars in the Taxi Station ----------------------------------------
			TaxiStationOperations.printAllCars(taxiStation);

// --------------- calculate cost of all cars of the Taxi Station ---------------------------
			TaxiStationOperations.calculateCost(taxiStation);


//--------------- sort cars of the Taxi Station by fuel consumption -------------------------
			Collections.sort(taxiStation, new FuelConsumptionComparator());
			System.out.println("\nOrder of cars in the Taxi Station on fuel consumption:");
			int count = 0;
			for (Vehicle car : taxiStation) {
				System.out.println(++count + ". {" + car.getType() + "}" + ", " +
						"{\"" + car.getModel() + "\"}" + ", " +
						"{" + car.getLitresPerHudredKm() + " lpk}");
			}

		} catch (NoSuchElementException nsee) {
			System.err.println("No more tokens are available to scan\n" + nsee.getStackTrace());
		} catch (IllegalStateException ise) {
			System.err.println("This scanner is closed\n" + ise.getStackTrace());
		} catch (ClassCastException ссe) {
			ссe.printStackTrace();
		} catch (Exception e) {
			System.out.println("Fatal error has been occured");
			e.printStackTrace();
		}
	}
}
