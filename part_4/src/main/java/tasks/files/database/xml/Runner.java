package tasks.files.database.xml;

import com.sun.org.apache.xpath.internal.SourceTree;

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
 * @version 5.0
 * @since 04/16/2018
 */
public class Runner {

    //------------------------------- Paths to files --------------------------------------------------
    private static final String DATABASE_PROPERTIES = "dbproperties\\database.prop";

    public static final String SEDANS_FILE_PATH = "resources\\Sedans.txt";
    public static final String CABRIOLETS_FILE_PATH = "resources\\Cabriolets.txt";
    public static final String CROSSOVERS_FILE_PATH = "resources\\Crossovers.txt";
    public static final String TRUCKS_FILE_PATH = "resources\\Trucks.txt";

    private static final String CARS_INFO_XML = "resources\\Cars.xml";

    //------------------------ Preparation reading from PostgeSQL ----------------------------------------
    static Properties properties = new Properties();

    // Properties loading. Static block starts first
    static {
        try {
            FileInputStream input = new FileInputStream(DATABASE_PROPERTIES);
            properties.load(input);
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Receiving properties's values from Properties object
    static String databaseURL = properties.getProperty("dbURL");
    static String user = properties.getProperty("user");
    static String password = properties.getProperty("password");
    static String driverName = properties.getProperty("driver");

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Vehicle> taxiStation = new ArrayList();
        TaxiStationOperations TaxiStationOperations = new TaxiStationOperations();

        boolean repeat = true;

        while (repeat) {
            try {
                System.out.println("Please select source to read information from:\n1. - .txt file\n2. - PostgreSQL\n" +
                        "3. - .xml file\n0. - Exit");

                int dataSourceReading;
                int carTypeReading;
                int carIdReading;

                dataSourceReading = scan.nextInt();
                if (dataSourceReading != 1 && dataSourceReading != 2 && dataSourceReading != 3 && dataSourceReading != 0) {
                    System.err.println("You should specify a number from the list.");
                    throw new InputMismatchException();
                }
                switch (dataSourceReading) {

                    case (1):
                        System.out.println("Please select car type to read from .txt file:\n1. - Sedan" +
                                "\n2. - Cabriolet\n3. - Crossover\n4. - Truck\n0. - Exit");
                        carTypeReading = scan.nextInt();
                        if (carTypeReading != 1 && carTypeReading != 2 && carTypeReading != 3 && carTypeReading != 4
                                && carTypeReading != 0) {
                            System.err.println("You should specify a number from the list.");
                            throw new InputMismatchException();
                        }
                        switch (carTypeReading) {

                            case (1):
                                TxtFileReaderForSedan txtFileReaderForSedan = new TxtFileReaderForSedan(SEDANS_FILE_PATH);
                                System.out.println("Please input Sedan's id to add into ArrayList:");
                                carIdReading = scan.nextInt();
                                Sedan sedan = txtFileReaderForSedan.readInfo(carIdReading);
                                if (sedan == null) {
                                    throw new InvalidCarTypeException("Sedan");
                                }
                                taxiStation.add(sedan);
                                if (!(sedan.getType().equals("Sedan"))) {
                                    throw new InvalidCarTypeException("Sedan");
                                }
                                System.out.println(sedan.toString() + " is added into collection");
                                break;

                            case (2):
                                TxtFileReaderForCabriolet txtFileReaderForCabriolet = new TxtFileReaderForCabriolet(CABRIOLETS_FILE_PATH);
                                System.out.println("Please input Cabriolet's id to add into ArrayList:");
                                carIdReading = scan.nextInt();
                                Cabriolet cabriolet = txtFileReaderForCabriolet.readInfo(carIdReading);
                                if (cabriolet == null) {
                                    throw new InvalidCarTypeException("Cabriolet");
                                }
                                taxiStation.add(cabriolet);
                                if (!(cabriolet.getType().equals("Cabriolet"))) {
                                    throw new InvalidCarTypeException("Cabriolet");
                                }
                                System.out.println(cabriolet.toString() + " is added into collection");
                                break;

                            case (3):
                                TxtFileReaderForCrossover txtFileReaderForCrossover = new TxtFileReaderForCrossover(CROSSOVERS_FILE_PATH);
                                System.out.println("Please input Crossover's id to add into ArrayList:");
                                carIdReading = scan.nextInt();
                                Crossover crossover = txtFileReaderForCrossover.readInfo(carIdReading);
                                if (crossover == null) {
                                    throw new InvalidCarTypeException("Crossover");
                                }
                                taxiStation.add(crossover);
                                if (!(crossover.getType().equals("Crossover"))) {
                                    throw new InvalidCarTypeException("Crossover");
                                }
                                System.out.println(crossover.toString() + " is added into collection");
                                break;

                            case (4):
                                TxtFileReaderForTruck txtFileReaderForTruck = new TxtFileReaderForTruck(TRUCKS_FILE_PATH);
                                System.out.println("Please input Truck's id to add into ArrayList:");
                                carIdReading = scan.nextInt();
                                Truck truck = txtFileReaderForTruck.readInfo(carIdReading);
                                if (truck == null) {
                                    throw new InvalidCarTypeException("Truck");
                                }
                                taxiStation.add(truck);
                                if (!(truck.getType().equals("Truck"))) {
                                    throw new InvalidCarTypeException("Truck");
                                }
                                System.out.println(truck.toString() + " is added into collection");
                                break;

                            case (0):
                                System.out.println("Completed");
                                repeat = false;
                                break;
                        }
                        break;

                    case (2):
                        //------------------ Driver registration -----------------------------------------
                        try {
                            Class.forName(driverName);
                            System.out.println("PostgreSQL JDBC driver is loaded");
                        } catch (ClassNotFoundException e) {
                            System.out.println("Postgresql JDBC driver is not found");
                        }

                        // --------------------  creation connection ------------------------------------
                        Connection connection = null;
                        try {
                            connection = DriverManager.getConnection(databaseURL, user, password);
                            System.out.println("Connection is opened");
                        } catch (SQLException e) {
                            System.out.println("SQLException " + e.getMessage());
                        }

                        System.out.println("Please select car type to read from PostgreSQL:\n1. - Sedan" +
                                "\n2. - Cabriolet\n3. - Crossover\n4. - Truck\n0. - Exit");
                        carTypeReading = scan.nextInt();
                        if (carTypeReading != 1 && carTypeReading != 2 && carTypeReading != 3 && carTypeReading != 4
                                && carTypeReading != 0) {
                            System.err.println("You should specify a number from the list.");
                            throw new InputMismatchException();
                        }

                        switch (carTypeReading) {
                            case (1):
                                // ------------------- DataBaseReader for sedans---------------------------------
                                SedanDatabaseReader sedanDbReader = new SedanDatabaseReader(connection);

                                System.out.println("Please input Sedan's id to add into ArrayList:");
                                carIdReading = scan.nextInt();
                                Sedan sedan = sedanDbReader.readInfo(carIdReading);
                                if (sedan == null) {
                                    throw new InvalidCarTypeException("Sedan");
                                }
                                //Add Sedan object into collection
                                taxiStation.add(sedan);
                                if (!(sedan.getType().equals("Sedan"))) {
                                    throw new InvalidCarTypeException("Sedan");
                                }
                                System.out.println(sedan.toString() + " is added into collection");

                                // -------------------- close connection -----------------------------------------
                                try {
                                    if (connection != null) {
                                        connection.close();
                                        System.out.println("Connection is closed");
                                    }
                                } catch (SQLException e) {
                                    System.err.println("SQLException is throwed:\nStackTrace:\n" + e.getStackTrace());
                                }
                                break;

                            case (2):
                                // ------------------- DataBaseReader for Cabriolets---------------------------------
                                CabrioletDatabaseReader сabrioletDbReader = new CabrioletDatabaseReader(connection);

                                System.out.println("Please input Cabriolet's id to add into ArrayList:");
                                carIdReading = scan.nextInt();
                                Cabriolet сabriolet = сabrioletDbReader.readInfo(carIdReading);
                                if (сabriolet == null) {
                                    throw new InvalidCarTypeException("Cabriolet");
                                }
                                //Add Cabriolet object into collection
                                taxiStation.add(сabriolet);
                                if (!(сabriolet.getType().equals("Cabriolet"))) {
                                    throw new InvalidCarTypeException("Cabriolet");
                                }
                                System.out.println(сabriolet.toString() + " is added into collection");

                                // -------------------- close connection -----------------------------------------
                                try {
                                    if (connection != null) {
                                        connection.close();
                                        System.out.println("Connection is closed");
                                    }
                                } catch (SQLException e) {
                                    System.err.println("SQLException is throwed:\nStackTrace:\n" + e.getStackTrace());
                                }
                                break;

                            case (3):
                                // ------------------- DataBaseReader for Crossovers---------------------------------
                                CrossoverDatabaseReader crossoverDbReader = new CrossoverDatabaseReader(connection);

                                System.out.println("Please input Crossover's id to add into ArrayList:");
                                carIdReading = scan.nextInt();
                                Crossover crossover = crossoverDbReader.readInfo(carIdReading);
                                if (crossover == null) {
                                    throw new InvalidCarTypeException("Crossover");
                                }
                                //Add Crossover object into collection
                                taxiStation.add(crossover);
                                if (!(crossover.getType().equals("Crossover"))) {
                                    throw new InvalidCarTypeException("Crossover");
                                }
                                System.out.println(crossover.toString() + " is added into collection");

                                // -------------------- close connection -----------------------------------------
                                try {
                                    if (connection != null) {
                                        connection.close();
                                        System.out.println("Connection is closed");
                                    }
                                } catch (SQLException e) {
                                    System.err.println("SQLException is throwed:\nStackTrace:\n" + e.getStackTrace());
                                }
                                break;

                            case (4):
                                // ------------------- DataBaseReader for Trucks---------------------------------
                                TruckDatabaseReader truckDbReader = new TruckDatabaseReader(connection);

                                System.out.println("Please input Truck's id to add into ArrayList:");
                                carIdReading = scan.nextInt();
                                Truck truck = truckDbReader.readInfo(carIdReading);
                                if (truck == null) {
                                    throw new InvalidCarTypeException("Truck");
                                }
                                //Add Truck object into collection
                                taxiStation.add(truck);
                                if (!(truck.getType().equals("Truck"))) {
                                    throw new InvalidCarTypeException("Truck");
                                }
                                System.out.println(truck.toString() + " is added into collection");

                                // -------------------- close connection -----------------------------------------
                                try {
                                    if (connection != null) {
                                        connection.close();
                                        System.out.println("Connection is closed");
                                    }
                                } catch (SQLException e) {
                                    System.err.println("SQLException is throwed:\nStackTrace:\n" + e.getStackTrace());
                                }
                                break;

                            case (0):
                                System.out.println("Completed");
                                repeat = false;

                                // -------------------- close connection -----------------------------------------
                                try {
                                    if (connection != null) {
                                        connection.close();
                                        System.out.println("Connection is closed");
                                    }
                                } catch (SQLException e) {
                                    System.err.println("SQLException is throwed:\nStackTrace:\n" + e.getStackTrace());
                                }
                                break;



                        }
                        break;

                    case (3):

                        break;

                }


//// ------------------- search a car by parameters in the Taxi Station ---------------------
//                boolean condition = true;
//                System.out.println("\nPlease select an appropriate car by car's type, car's brand, " +
//                        "transmission type, color and minimum year of car's manufacture");
//                while (condition) {
//                    String carType = TaxiStationOperations.searchCarType(scan);
//                    if (carType.equals("Not selected")) {
//                        break;
//                    }
//
//                    String carModel = TaxiStationOperations.searchCarModel(scan);
//                    if (carModel.equals("Not selected")) {
//                        break;
//                    }
//
//                    String carTransmissionType = TaxiStationOperations.searchCarTransmissionType(scan);
//                    if (carTransmissionType.equals("Not selected")) {
//                        break;
//                    }
//
//                    String carColor = TaxiStationOperations.searchCarColor(scan);
//                    if (carTransmissionType.equals("Not selected")) {
//                        break;
//                    }
//
//                    int сarManufactureYear = TaxiStationOperations.searchCarManufactureYear(scan);
//
//                    TaxiStationOperations.searchCarByParameters(taxiStation, carType, carModel, carTransmissionType,
//                            carColor, сarManufactureYear);
//                }

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
                repeat = false;
                System.err.println("You inputted incorrect symbol\nStackTrace:\n" + nsee.getStackTrace());
            } catch (InvalidCarTypeException icte) {
                System.err.println("You inputted incorrect car's id.\nStackTrace:\n" + icte.getStackTrace());
            } catch (IllegalStateException ise) {
                System.err.println("This scanner is closed\nStackTrace:\n" + ise.getStackTrace());
            } catch (ClassCastException ссe) {
                ссe.printStackTrace();
            } catch (NullPointerException npe) {
                System.err.println("NullPointerException throwed.\nStackTrace:\n" + npe.getStackTrace());
            } catch (Exception e) {
                System.err.println("Fatal error\nStackTrace:\n" + e.getStackTrace());
            }
        }
    }
}
