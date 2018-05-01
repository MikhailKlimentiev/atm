//===================================================================================================================
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////                                                                                                             ////
////    PRE-SELECTION FOR TEST AUTOMATION MENTORING PARTICIPATION: JAVA, part 4                                  ////
////                                                                                                             ////
////    Task 1 (часть 2 -- чтение из xml файла)                                                                  ////
////                                                                                                             ////
////    Дополнить объектную модель, реализованную в рамках заданий 2.1, 3.1, 3.2.                                ////
////    Добавить чтение данных из следующих источников:                                                          ////
////     - из xml-файла или из json-файла (на выбор).                                                            ////
////                                                                                                             ////
////    Для чтения из xml-файла использован SAX parser                                                           ////
////                                                                                                             ////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//===================================================================================================================

package tasks.saxparser;

import java.util.*;

/**
 * Runner.
 *
 * @author Mikhail Klimentsyeu
 * @version 4.0
 * @since 04/08/2018
 */
public class Runner {

    private static final String CARS_INFO_XML = "pre-selection_tasks\\resources\\Cars.xml";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Vehicle> taxiStation = new ArrayList();
        TaxiStationOperations TaxiStationOperations = new TaxiStationOperations();

        try {

            XMLFileReader xmlReader = new XMLFileReader(CARS_INFO_XML);
            taxiStation = xmlReader.readInfo();

// ================================ Search a car by parameters in the Taxi Station ====================================
            boolean condition = true;
            System.out.println("\nPlease select an appropriate car by car's type, car's brand, " + "transmission type," +
                    " color and minimum year of car's manufacture");
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

// ================================= Print all cars in the Taxi Station ==============================================
            TaxiStationOperations.printAllCars(taxiStation);

// ================================== Calculate cost of all cars of the Taxi Station =================================
            TaxiStationOperations.calculateCost(taxiStation);


// =================================== Sort cars of the Taxi Station by fuel consumption =============================
            Collections.sort(taxiStation, new FuelConsumptionComparator());
            System.out.println("\nOrder of cars in the Taxi Station on fuel consumption:");
            int count = 0;
            for (Vehicle car : taxiStation) {
                System.out.println(++count + ". {" + car.getType() + "}" + ", " + "{\"" + car.getModel() + "\"}"
                        + ", " + "{" + car.getLitresPerHudredKm() + " lpk}");
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
