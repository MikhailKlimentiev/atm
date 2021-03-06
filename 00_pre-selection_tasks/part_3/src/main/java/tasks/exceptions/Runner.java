//===================================================================================================================
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////                                                                                                             ////
////    PRE-SELECTION FOR TEST AUTOMATION MENTORING PARTICIPATION: JAVA, part 3                                  ////
////                                                                                                             ////
////    Task 1                                                                                                   ////
////                                                                                                             ////
////    Для объектной модели, реализованной в задании 2.1 (Таксопарк), необходимо реализовать                    ////
////    классы пользовательских исключений и организовать обработку возможных исключительных ситуаций,           ////
////    например, если элемент отсутствует в коллекции, если мы не можем удалить текущий элемент и т.д.          ////
////    Комментарии оставлять в классах исключений. Создать минимум 3 пользовательских исключения                ////
////    и использовать минимум 5 встроенных исключений.                                                          ////
////                                                                                                             ////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//===================================================================================================================

package tasks.exceptions;

import java.util.*;

/**
 * Runner.
 *
 * @author Mikhail Klimentsyeu
 * @version 2.0
 * @since 03/11/2018
 */
public class Runner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Vehicle> taxiStation = new ArrayList();
        TaxiStationOperations TaxiStationOperations = new TaxiStationOperations();

// ==================================== Sedan's objects creation ======================================================
        try {
            Sedan bmw3Series = new Sedan("Sedan", "BMW 3 series", "Automatic", 8.00,
                    40250, 5, 2013, "Black");
            Sedan bmw4Series = new Sedan("Sedan", "BMW 4 Series Gran Coupe", "Automatic",
                    8.71, 43300, 5, 2015, "Black");
            Sedan jaguar = new Sedan("Sedan", "Jaguar X-Type", "Automatic", 13.07,
                    35060, 5, 2008, "White");
            Sedan mercedesBenzC43 = new Sedan("Sedan", "Mercedes-Benz C43", "Manual",
                    12.0, 10000, 5, 2010, "Yellow");

// ==================================== Cabriolet's objects creation ==================================================
            Cabriolet audiA3Automatic = new Cabriolet("Cabriolet", "Audi A3 Convertible", "Automatic",
                    9.41, 38250, 4, 2018, "Black", true);
            Cabriolet audiA3Manual = new Cabriolet("Cabriolet", "Audi A3 Convertible", "Manual",
                    9.41, 35300, 4, 2018, "Blue", true);

// ==================================== Crossover's objects creation ==================================================
            Crossover jeepPatriot = new Crossover("Crossover", "Jeep Patriot 4dr", "Automatic",
                    10.69, 25840, 5, 2017, "Black");
            Crossover vwTiguan = new Crossover("Crossover", "Volkswagen Tiguan Limited 4dr", "Manual",
                    11, 21995, 5, 2017, "Back");

// ===================================== Truck's objects creation =====================================================
            Truck chevroletColorado15 = new Truck("Truck", "Chevrolet Colorado Crew Cab Pickup",
                    "Automatic", 12.38, 35780, 5, 2015,
                    "Black");
            Truck chevroletColorado16 = new Truck("Truck", "Chevrolet Colorado Crew Cab Pickup",
                    "Automatic", 12.38, 35780, 5,
                    2016, "White");

// ===================================== Adding cars to autopark ======================================================
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

// ================================ Search a car by parameters in the Taxi Station ===================================
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

// =========================== Print all cars in the Taxi Station ====================================================
            TaxiStationOperations.printAllCars(taxiStation);

// =========================== Calculate cost of all cars of the Taxi Station ========================================
            TaxiStationOperations.calculateCost(taxiStation);


// ============================ Sort cars of the Taxi Station by fuel consumption ====================================
            Collections.sort(taxiStation, new FuelConsumptionComparator());
            System.out.println("\nOrder of cars in the Taxi Station on fuel consumption:");
            int count = 0;
            for (Vehicle car : taxiStation) {
                System.out.println(++count + ". {" + car.getType() + "}" + ", " +
                        "{\"" + car.getModel() + "\"}" + ", " +
                        "{" + car.getLitresPerHudredKm() + " lpk}");
            }
        } catch (InvalidCarTypeException icte) {
            icte.warn();
        } catch (InvalidTransmissionTypeException itte) {
            itte.warn();
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
