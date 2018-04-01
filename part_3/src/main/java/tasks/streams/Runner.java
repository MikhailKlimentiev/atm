package tasks.database;

import tasks.streams.*;

import java.util.*;

/**
 * Runner.
 *
 * @author Mikhail Klimentsyeu
 * @version 3.0
 * @since 03/18/2018
 */
public class Runner {

	public static final String SEDANS_FILE_PATH = "resources\\Sedans.txt";
	public static final String CABRIOLETS_FILE_PATH = "resources\\Cabriolets.txt";
	public static final String CROSSOVERS_FILE_PATH = "resources\\Crossovers.txt";
	public static final String TRUCKS_FILE_PATH = "resources\\Trucks.txt";

	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);

		List<Vehicle> taxiStation = new ArrayList();
		TaxiStationOperations TaxiStationOperations = new TaxiStationOperations();

		try {
//			Creation objects with reading information from files
			TxtFileReaderForSedan txtFileReaderForSedan1 = new TxtFileReaderForSedan(SEDANS_FILE_PATH);
			Sedan bmw3Series = txtFileReaderForSedan1.readInfoFromFile(1);
			bmw3Series.drive();

			TxtFileReaderForSedan txtFileReaderForSedan2 = new TxtFileReaderForSedan(SEDANS_FILE_PATH);
			Sedan bmw4Series = txtFileReaderForSedan2.readInfoFromFile(2);
			bmw4Series.drive();

			TxtFileReaderForSedan txtFileReaderForSedan3 = new TxtFileReaderForSedan(SEDANS_FILE_PATH);
			Sedan jaguar = txtFileReaderForSedan3.readInfoFromFile(3);
			jaguar.drive();

			TxtFileReaderForSedan txtFileReaderForSedan4 = new TxtFileReaderForSedan(SEDANS_FILE_PATH);
			Sedan mercedesBenzC43 = txtFileReaderForSedan4.readInfoFromFile(4);
			mercedesBenzC43.drive();

			TxtFileReaderForCabriolet txtFileReaderForCabriolet1 = new TxtFileReaderForCabriolet(CABRIOLETS_FILE_PATH);
			Cabriolet audiA3Automatic = txtFileReaderForCabriolet1.readInfoFromFile(1);
			audiA3Automatic.drive();

			TxtFileReaderForCabriolet txtFileReaderForCabriolet2 = new TxtFileReaderForCabriolet(CABRIOLETS_FILE_PATH);
			Cabriolet audiA3Manual = txtFileReaderForCabriolet2.readInfoFromFile(2);
			audiA3Manual.drive();

			TxtFileReaderForCrossover txtFileReaderForCrossover1 = new TxtFileReaderForCrossover(CROSSOVERS_FILE_PATH);
			Crossover jeepPatriot = txtFileReaderForCrossover1.readInfoFromFile(1);
			jeepPatriot.drive();

			TxtFileReaderForCrossover txtFileReaderForCrossover2 = new TxtFileReaderForCrossover(CROSSOVERS_FILE_PATH);
			Crossover vwTiguan = txtFileReaderForCrossover2.readInfoFromFile(2);
			vwTiguan.drive();

			TxtFileReaderForTruck txtFileReaderForTruck1 = new TxtFileReaderForTruck(TRUCKS_FILE_PATH);
			Truck chevroletColorado15 = txtFileReaderForTruck1.readInfoFromFile(1);
			chevroletColorado15.drive();

			TxtFileReaderForTruck txtFileReaderForTruck2 = new TxtFileReaderForTruck(TRUCKS_FILE_PATH);
			Truck chevroletColorado16 = txtFileReaderForTruck2.readInfoFromFile(2);
			chevroletColorado16.drive();

//			adding cars to autopark
			taxiStation.add(bmw3Series);
			taxiStation.add(bmw4Series);
			taxiStation.add(jaguar);
			taxiStation.add(mercedesBenzC43);
			taxiStation.add(audiA3Automatic);
			taxiStation.add(audiA3Manual);
			taxiStation.add(jeepPatriot);
			taxiStation.add(vwTiguan);
			taxiStation.add(chevroletColorado15);
			taxiStation.add(chevroletColorado16);

//			Writing objects informaton into file
			TxtFileWriter txtFileWriter = new TxtFileWriter();
			txtFileWriter.writeObjectIntoFile(bmw3Series);
			txtFileWriter.writeObjectIntoFile(bmw4Series);
			txtFileWriter.writeObjectIntoFile(jaguar);
			txtFileWriter.writeObjectIntoFile(mercedesBenzC43);
			txtFileWriter.writeObjectIntoFile(audiA3Automatic);
			txtFileWriter.writeObjectIntoFile(audiA3Manual);
			txtFileWriter.writeObjectIntoFile(jeepPatriot);
			txtFileWriter.writeObjectIntoFile(vwTiguan);
			txtFileWriter.writeObjectIntoFile(chevroletColorado15);
			txtFileWriter.writeObjectIntoFile(chevroletColorado16);


//			search a car by parameters in the Taxi Station
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

//		print all cars in the Taxi Station
			TaxiStationOperations.printAllCars(taxiStation);

//		calculate cost of all cars of the Taxi Station
			TaxiStationOperations.calculateCost(taxiStation);


//		sort cars of the Taxi Station by fuel consumption
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
