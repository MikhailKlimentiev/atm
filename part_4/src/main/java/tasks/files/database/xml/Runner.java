//===================================================================================================================
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////                                                                                                             ////
////    PRE-SELECTION FOR TEST AUTOMATION MENTORING PARTICIPATION: JAVA, part 4                                  ////
////                                                                                                             ////
////    Task 1 (часть 3 -- чтение из txt файла, чтение из базы данных PostgreSQL, чтение из xml файла)           ////
////                                                                                                             ////
////    Дополнить объектную модель, реализованную в рамках заданий 2.1, 3.1, 3.2.                                ////
////    Добавить чтение данных из следующих источников:                                                          ////
////     - из базы данных (базу данных можно выбрать самостоятельно) с использованием jdbc – драйвера;           ////
////     - из xml-файла или из json-файла (на выбор).                                                            ////
////                                                                                                             ////
////    В программе можно указать источник для чтения данных:                                                    ////
////    1. txt файл                                                                                              ////
////    2. База данных PostgreSQL                                                                                ////
////    3. xml файл                                                                                              ////
////                                                                                                             ////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//===================================================================================================================

package tasks.files.database.xml;

import tasks.files.database.xml.*;

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
 * @version 6.0
 * @since 04/21/2018
 */

public class Runner {

    // ======================================== Paths to files =======================================================
    private static final String DATABASE_PROPERTIES = "dbproperties\\database.prop";

    public static final String SEDANS_FILE_PATH = "resources\\Sedans.txt";
    public static final String CABRIOLETS_FILE_PATH = "resources\\Cabriolets.txt";
    public static final String CROSSOVERS_FILE_PATH = "resources\\Crossovers.txt";
    public static final String TRUCKS_FILE_PATH = "resources\\Trucks.txt";

    private static final String CARS_INFO_XML = "resources\\Cars.xml";

    // ================================== Preparation reading from PostgeSQL =========================================
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
        try {
            while (repeat) {

                System.out.println("Please select source to read information from:\n1. - .txt file\n2. - PostgreSQL\n" +
                        "3. - .xml file\n0. - Exit");

                int dataSourceReading;
                int carTypeReading;
                int carIdReading;

                // ========================== Check that Data Source input is int =====================================
                if (scan.hasNextInt()) {
                    dataSourceReading = scan.nextInt();
                    // =========================== Switch for Data Source =============================================
                    switch (dataSourceReading) {
                        case (1): {
                            System.out.println("Please select car type to read from .txt file:\n1. - Sedan" +
                                    "\n2. - Cabriolet\n3. - Crossover\n4. - Truck\n0. - Exit");
                            // ============= Check that Car Type input is int if reading from .txt file ===============
                            if (scan.hasNextInt()) {
                                carTypeReading = scan.nextInt();
                                // ================== Switch for Car Type if reading from .txt file ===================
                                switch (carTypeReading) {
                                    case (1): {
                                        TxtFileReaderForSedan txtFileReaderForSedan = new TxtFileReaderForSedan(SEDANS_FILE_PATH);
                                        System.out.println("Please input Sedan's id to add into ArrayList:");
                                        // Check car id input is int
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            Sedan sedan = txtFileReaderForSedan.readInfo(carIdReading);
                                            // Check car id input is valid
                                            if (sedan == null) {
                                                throw new InvalidCarTypeException("Sedan");
                                            }
                                            taxiStation.add(sedan);
                                            System.out.println(sedan.toString() + " is added into collection");
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (2): {
                                        TxtFileReaderForCabriolet txtFileReaderForCabriolet = new TxtFileReaderForCabriolet(CABRIOLETS_FILE_PATH);
                                        System.out.println("Please input Cabriolet's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            Cabriolet cabriolet = txtFileReaderForCabriolet.readInfo(carIdReading);
                                            if (cabriolet == null) {
                                                throw new InvalidCarTypeException("Cabriolet");
                                            }
                                            taxiStation.add(cabriolet);
                                            System.out.println(cabriolet.toString() + " is added into collection");
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (3): {
                                        TxtFileReaderForCrossover txtFileReaderForCrossover = new TxtFileReaderForCrossover(CROSSOVERS_FILE_PATH);
                                        System.out.println("Please input Crossover's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            Crossover crossover = txtFileReaderForCrossover.readInfo(carIdReading);
                                            if (crossover == null) {
                                                throw new InvalidCarTypeException("Crossover");
                                            }
                                            taxiStation.add(crossover);
                                            System.out.println(crossover.toString() + " is added into collection");
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (4): {
                                        TxtFileReaderForTruck txtFileReaderForTruck = new TxtFileReaderForTruck(TRUCKS_FILE_PATH);
                                        System.out.println("Please input Truck's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            Truck truck = txtFileReaderForTruck.readInfo(carIdReading);
                                            if (truck == null) {
                                                throw new InvalidCarTypeException("Truck");
                                            }
                                            taxiStation.add(truck);
                                            System.out.println(truck.toString() + " is added into collection");
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (0): {
                                        System.out.println("Adding cars into taxiPark collection is completed.\n");
                                        repeat = false;
                                        break;
                                    }
                                    default: {
                                        System.err.println("Incorrect value! Please, try again.");
                                        break;
                                    }
                                }
                                // Check that Car Type input is int if reading from .txt
                            } else {
                                scan.next();
                                System.err.println("You inputted not a number. Please try again.");
                            }
                            // for case #1 (Reading from .txt file)
                            break;
                        }
                        case (2): {
                            // ============================ Driver registration ======================================
                            try {
                                Class.forName(driverName);
                                System.out.println("PostgreSQL JDBC driver is loaded");
                            } catch (ClassNotFoundException e) {
                                System.out.println("Postgresql JDBC driver is not found");
                            }

                            // =========================== Creation connection =======================================
                            Connection connection = null;
                            try {
                                connection = DriverManager.getConnection(databaseURL, user, password);
                                System.out.println("Connection is opened");
                            } catch (SQLException e) {
                                System.out.println("SQLException " + e.getMessage());
                            }

                            System.out.println("Please select car type to read from PostgreSQL:\n1. - Sedan" +
                                    "\n2. - Cabriolet\n3. - Crossover\n4. - Truck\n0. - Exit");
                            // ============ Check that Car Type input is int if reading from PostgreSQL ==============
                            if (scan.hasNextInt()) {
                                carTypeReading = scan.nextInt();
                                // ================= Switch for Car Type if reading from PostgreSQL ===================
                                switch (carTypeReading) {
                                    case (1): {
                                        // ================== DataBaseReader for sedans ===============================
                                        SedanDatabaseReader sedanDbReader = new SedanDatabaseReader(connection);

                                        System.out.println("Please input Sedan's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            Sedan sedan = sedanDbReader.readInfo(carIdReading);
                                            if (sedan == null) {
                                                throw new InvalidCarTypeException("Sedan");
                                            }
                                            taxiStation.add(sedan);
                                            System.out.println(sedan.toString() + " is added into collection");
                                            // ========================== Close connection ============================
                                            try {
                                                if (connection != null) {
                                                    connection.close();
                                                    System.out.println("Connection is closed");
                                                }
                                            } catch (SQLException e) {
                                                System.err.println("SQLException is throwed:\nStackTrace:\n" + e.getLocalizedMessage());
                                            }
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (2): {
                                        // =================== DataBaseReader for Cabriolets ==========================
                                        CabrioletDatabaseReader сabrioletDbReader = new CabrioletDatabaseReader(connection);

                                        System.out.println("Please input Cabriolet's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            Cabriolet cabriolet = сabrioletDbReader.readInfo(carIdReading);
                                            if (cabriolet == null) {
                                                throw new InvalidCarTypeException("Sedan");
                                            }
                                            taxiStation.add(cabriolet);
                                            System.out.println(cabriolet.toString() + " is added into collection");
                                            // ======================== Close connection =============================
                                            try {
                                                if (connection != null) {
                                                    connection.close();
                                                    System.out.println("Connection is closed");
                                                }
                                            } catch (SQLException e) {
                                                System.err.println("SQLException is throwed:\nStackTrace:\n" + e.getLocalizedMessage());
                                            }
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (3): {
                                        // ================ DataBaseReader for Crossovers =============================
                                        CrossoverDatabaseReader crossoverDbReader = new CrossoverDatabaseReader(connection);

                                        System.out.println("Please input Crossover's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            Crossover crossover = crossoverDbReader.readInfo(carIdReading);
                                            if (crossover == null) {
                                                throw new InvalidCarTypeException("Sedan");
                                            }
                                            taxiStation.add(crossover);
                                            System.out.println(crossover.toString() + " is added into collection");
                                            // ============================= Close connection =======================
                                            try {
                                                if (connection != null) {
                                                    connection.close();
                                                    System.out.println("Connection is closed");
                                                }
                                            } catch (SQLException e) {
                                                System.err.println("SQLException is throwed:\nStackTrace:\n" + e.getLocalizedMessage());
                                            }
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (4): {
                                        // ==================== DataBaseReader for Trucks ===============================
                                        TruckDatabaseReader truckDbReader = new TruckDatabaseReader(connection);

                                        System.out.println("Please input Truck's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            Truck truck = truckDbReader.readInfo(carIdReading);
                                            if (truck == null) {
                                                throw new InvalidCarTypeException("Sedan");
                                            }
                                            taxiStation.add(truck);
                                            System.out.println(truck.toString() + " is added into collection");
                                            // ================== Close connection ======================================
                                            try {
                                                if (connection != null) {
                                                    connection.close();
                                                    System.out.println("Connection is closed");
                                                }
                                            } catch (SQLException e) {
                                                System.err.println("SQLException is throwed:\nStackTrace:\n" + e.getLocalizedMessage());
                                            }
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (0): {
                                        System.out.println("Adding cars into taxiPark collection is completed.\n");
                                        repeat = false;

                                        // ================= Close connection =========================================
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
                                    default: {
                                        System.err.println("Incorrect value! Please, try again.");
                                        break;
                                    }
                                }
                                // Check that Car Type input is int if reading from PostgreSQL
                            } else {
                                scan.next();
                                System.err.println("You inputted not a number. Please try again.");
                            }
                            // for case #2 (Reading from PostgreSQL)
                            break;
                        }
                        case (3): {
                            System.out.println("Please select car type to read from .xml file:\n1. - Sedan" +
                                    "\n2. - Cabriolet\n3. - Crossover\n4. - Truck\n0. - Exit");

                            // ================= Check that Car Type input is int if reading from .xml file ==========
                            if (scan.hasNextInt()) {
                                carTypeReading = scan.nextInt();
                                // =============== Switch for Car Type if reading from .xml file ======================
                                switch (carTypeReading) {
                                    case (1): {
                                        System.out.println("Please input Sedan's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            XMLFileReaderSedan xmlReaderSedan = new XMLFileReaderSedan(CARS_INFO_XML);
                                            Sedan sedan = (Sedan) xmlReaderSedan.readInfo(carIdReading);
                                            if (sedan == null) {
                                                throw new InvalidCarTypeException("Sedan");
                                            }
                                            taxiStation.add(sedan);
                                            System.out.println(sedan.toString() + " is added into collection");
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (2): {
                                        System.out.println("Please input Cabriolet's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            XMLFileReaderCabriolet xmlReaderCabriolet = new XMLFileReaderCabriolet(CARS_INFO_XML);
                                            Cabriolet cabriolet = (Cabriolet) xmlReaderCabriolet.readInfo(carIdReading);
                                            if (cabriolet == null) {
                                                throw new InvalidCarTypeException("Cabriolet");
                                            }
                                            taxiStation.add(cabriolet);
                                            System.out.println(cabriolet.toString() + " is added into collection");
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (3): {
                                        System.out.println("Please input Crossover's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            XMLFileReaderCrossover xmlReaderCrossover = new XMLFileReaderCrossover(CARS_INFO_XML);
                                            Crossover crossover = (Crossover) xmlReaderCrossover.readInfo(carIdReading);
                                            if (crossover == null) {
                                                throw new InvalidCarTypeException("Crossover");
                                            }
                                            taxiStation.add(crossover);
                                            System.out.println(crossover.toString() + " is added into collection");
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (4): {
                                        System.out.println("Please input Truck's id to add into ArrayList:");
                                        if (scan.hasNextInt()) {
                                            carIdReading = scan.nextInt();
                                            XMLFileReaderTruck xmlReaderTruck = new XMLFileReaderTruck(CARS_INFO_XML);
                                            Truck truck = (Truck) xmlReaderTruck.readInfo(carIdReading);
                                            if (truck == null) {
                                                throw new InvalidCarTypeException("Truck");
                                            }
                                            taxiStation.add(truck);
                                            System.out.println(truck.toString() + " is added into collection");
                                        } else {
                                            scan.next();
                                            System.err.println("You inputted not a number. Please try again.");
                                        }
                                        break;
                                    }
                                    case (0): {
                                        System.out.println("Adding cars into taxiPark collection is completed.\n");
                                        repeat = false;
                                        break;
                                    }
                                    default: {
                                        System.err.println("Incorrect value! Please, try again.");
                                        break;
                                    }
                                }
                                // Check that Car Type input is int if reading from .xml file
                            } else {
                                scan.next();
                                System.out.println("You inputted not a number. Please try again.");
                            }
                            // for case #3 (Reading from PostgreSQL)
                            break;
                        }
                        case (0): {
                            System.out.println("Adding cars into taxiPark collection is completed.\n");
                            repeat = false;
                            break;
                        }
                        default: {
                            System.err.println("Incorrect value! Please, try again.");
                            break;
                        }
                    }
                    // Check that Data Source input is int
                } else {
                    scan.next();
                    System.err.println("You inputted not a number! Please try again.");
                }
            }

// ============================== Search a car by parameters in the Taxi Station =====================================
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

// =================================== Print all cars in the Taxi Station ============================================
            TaxiStationOperations.printAllCars(taxiStation);

// ===================================== Calculate cost of all cars of the Taxi Station ==============================
            TaxiStationOperations.calculateCost(taxiStation);


// ===================================== Sort cars of the Taxi Station by fuel consumption ===========================
            Collections.sort(taxiStation, new FuelConsumptionComparator());
            if (taxiStation.size() <= 0) {
                throw new EmptyCollectionException("It's impossible to sort cars of Taxi Station by fuel consumption because the collection is empty.");
            }
            System.out.println("\nOrder of cars in the Taxi Station on fuel consumption:");
            int count = 0;
            for (Vehicle car : taxiStation) {
                System.out.println(++count + ". {" + car.getType() + "}" + ", " +
                        "{\"" + car.getModel() + "\"}" + ", " +
                        "{" + car.getLitresPerHudredKm() + " lpk}");
            }

        } catch (InvalidCarTypeException icte) {
            System.err.println("You inputted incorrect car's id. Please try again.\nStackTrace:\n" + icte.fillInStackTrace());
        } catch (EmptyCollectionException ece) {
            System.err.println("EmptyCollectionException: " + ece.getMessage());
        } catch (IllegalStateException ise) {
            System.err.println("This scanner is closed\nStackTrace:\n" + ise.fillInStackTrace());
        } catch (ClassCastException ссe) {
            ссe.printStackTrace();
        } catch (NullPointerException npe) {
            System.err.println("NullPointerException throwed.\nStackTrace:\n" + npe.fillInStackTrace());
        } catch (Exception e) {
            System.err.println("Fatal error.\nStackTrace:\n" + e.fillInStackTrace());
        }
    }

}
