//===================================================================================================================
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////                                                                                                             ////
////    PRE-SELECTION FOR TEST AUTOMATION MENTORING PARTICIPATION: JAVA, part 4                                  ////
////                                                                                                             ////
////    Task 1 (часть 1 -- чтение из базы данных PostgreSQL)                                                     ////
////                                                                                                             ////
////    Дополнить объектную модель, реализованную в рамках заданий 2.1, 3.1, 3.2.                                ////
////    Добавить чтение данных из следующих источников:                                                          ////
////     - из базы данных (базу данных можно выбрать самостоятельно) с использованием jdbc – драйвера;           ////
////                                                                                                             ////
////    Используемая база данных: PostgreSQL                                                                     ////
////                                                                                                             ////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//===================================================================================================================

package tasks.database;

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

    private static final String DATABASE_PROPERTIES = "pre-selection_tasks\\dbproperties\\database.prop";

    static Properties properties = new Properties();

    // ====================== Properties loading. Static block starts first ==========================================
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

    // ======================== Receiving properties's values from Properties object ================================
    static String databaseURL = properties.getProperty("dbURL");
    static String user = properties.getProperty("user");
    static String password = properties.getProperty("password");
    static String driverName = properties.getProperty("driver");

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Vehicle> taxiStation = new ArrayList();
        TaxiStationOperations TaxiStationOperations = new TaxiStationOperations();

        try {

//==================================== Driver registration ============================================================
            try {
                Class.forName(driverName);
                System.out.println("PostgreSQL JDBC driver is loaded");
            } catch (ClassNotFoundException e) {
                System.out.println("Postgresql JDBC driver is not found");
            }

// =================================== Creation connection ===========================================================
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(databaseURL, user, password);
                System.out.println("Connection is opened");
            } catch (SQLException e) {
                System.out.println("SQLException " + e.getMessage());
            }

// ==================================== DataBaseReader for sedans ====================================================

            SedanDatabaseReader sedanDbReader = new SedanDatabaseReader(connection);
            try {
                Sedan sedan1 = sedanDbReader.readInfo(1);
                //Add Sedan object into collection
                taxiStation.add(sedan1);
                System.out.println(sedan1.toString() + " is added into collection");
            } catch (NullPointerException ex) {
                System.out.println("There is not sedan with id = 1");
            }

            try {
                Sedan sedan2 = sedanDbReader.readInfo(2);
                taxiStation.add(sedan2);
                System.out.println(sedan2.toString() + " is added into collection");
            } catch (NullPointerException ex) {
                System.out.println("There is not sedan with id = 2");
            }

            try {
                Sedan sedan3 = sedanDbReader.readInfo(3);
                taxiStation.add(sedan3);
                System.out.println(sedan3.toString() + " is added into collection");
            } catch (NullPointerException ex) {
                System.out.println("There is not sedan with id = 3");
            }

            try {
                Sedan sedan4 = sedanDbReader.readInfo(4);
                taxiStation.add(sedan4);
                System.out.println(sedan4.toString() + " is added into collection");
            } catch (NullPointerException ex) {
                System.out.println("There is not sedan with id = 4");
            }

// ================================= DataBaseReader for Cabriolets ===================================================
            CabrioletDatabaseReader сabrioletDbReader = new CabrioletDatabaseReader(connection);
            try {
                Cabriolet сabriolet1 = сabrioletDbReader.readInfo(1);
                taxiStation.add(сabriolet1);
                System.out.println(сabriolet1.toString() + " is added into collection");
            } catch (NullPointerException ex) {
                System.out.println("There is not сabriolet with id = 1");
            }

            try {
                Cabriolet сabriolet2 = сabrioletDbReader.readInfo(2);
                taxiStation.add(сabriolet2);
                System.out.println(сabriolet2.toString() + " is added into collection");
            } catch (NullPointerException ex) {
                System.out.println("There is not сabriolet with id = 2");
            }

// ================================= DataBaseReader for Crossovers ====================================================

            CrossoverDatabaseReader crossoverDbReader = new CrossoverDatabaseReader(connection);
            try {
                Crossover crossover1 = crossoverDbReader.readInfo(1);
                taxiStation.add(crossover1);
                System.out.println(crossover1.toString() + " is added into collection");
            } catch (NullPointerException ex) {
                System.out.println("There is not crossover with id = 1");
            }

            try {
                Crossover crossover2 = crossoverDbReader.readInfo(2);
                taxiStation.add(crossover2);
                System.out.println(crossover2.toString() + " is added into collection");
            } catch (NullPointerException ex) {
                System.out.println("There is not crossover with id = 2");
            }

// ==================================== DataBaseReader for Trucks ====================================================

            TruckDatabaseReader truckDbReader = new TruckDatabaseReader(connection);
            try {
                Truck truck1 = truckDbReader.readInfo(1);
                taxiStation.add(truck1);
                System.out.println(truck1.toString() + " is added into collection");
            } catch (NullPointerException ex) {
                System.out.println("There is not truck with id = 1");
            }

            try {
                Truck truck2 = truckDbReader.readInfo(2);
                taxiStation.add(truck2);
                System.out.println(truck2.toString() + " is added into collection");
            } catch (NullPointerException ex) {
                System.out.println("There is not truck with id = 2");
            }

// ====================================== Close connection ===========================================================
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
            }


// ===================================== Search a car by parameters in the Taxi Station ==============================
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

// ================================= Print all cars in the Taxi Station ===============================================
            TaxiStationOperations.printAllCars(taxiStation);

// =================================== Calculate cost of all cars of the Taxi Station =================================
            TaxiStationOperations.calculateCost(taxiStation);


// ==================================== Sort cars of the Taxi Station by fuel consumption ============================
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
