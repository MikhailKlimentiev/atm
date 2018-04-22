//===================================================================================================================
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////                                                                                                             ////
////    PRE-SELECTION FOR TEST AUTOMATION MENTORING PARTICIPATION: JAVA, part 2                                  ////
////                                                                                                             ////
////    Task 1                                                                                                   ////
////                                                                                                             ////
////    Спроектировать объектную модель для заданной предметной области.                                         ////
////    Использовать (продемонстрировать умение работать):                                                       ////
////      - классы (abstract классы – по возможности),                                                           ////
////      - интерфейсы,                                                                                          ////
////      - наследование,                                                                                        ////
////      - полиморфизм,                                                                                         ////
////      - инкапсуляция,                                                                                        ////
////      - коллекции.                                                                                           ////
////                                                                                                             ////
////    Каждый класс, метод и переменная должны иметь исчерпывающее смысл название и информативный состав.       ////
////    Необходимо точно продумать, какие классы необходимы для решения задачи. Наследование должно              ////
////    применяться только тогда, когда это имеет смысл. Классы должны быть грамотно разложены по пакетам.       ////
////    Работа с консолью или консольное меню должно быть минимальным (только необходимые данные для ввода,      ////
////    выводить только то, что просится в условии задачи). Задание представляет собой какую-то предметную       ////
////    область, в которой требуется выделить необходимую иерархию классов и реализовать ее с помощью ООП        ////
////    (используя наследование, если необходимо или реализовывая интерфейсы). В каждом классе должны быть       ////
////    поля и методы, которые вы посчитаете необходимыми. Программа должна создавать объекты различных          ////
////    классов в выделенной предметной области, объединять их в какой-то набор объектов                         ////
////    (использовать коллекции). Как правило, задание требует выполнить какое-то действие над объектами         ////
////    в коллекции объектов по заданным критериям.                                                              ////
////                                                                                                             ////
////    Варианты заданий (необходимо выбрать/реализовать один любой вариант):                                    ////
////                                                                                                             ////
////    6. Таксопарк. Определить иерархию легковых автомобилей. Создать таксопарк.                               ////
////    Посчитать стоимость автопарка. Провести сортировку автомобилей парка по расходу топлива.                 ////
////    Найти автомобиль в компании, соответствующий заданному диапазону параметров.                             ////
////                                                                                                             ////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//===================================================================================================================

package tasks.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Runner.
 *
 * @author Mikhail Klimentsyeu
 * @version 1.0
 * @since 03/09/2018
 */
public class Runner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Vehicle> taxiStation = new ArrayList();
        TaxiStationOperations taxiStationOperations = new TaxiStationOperations();

// ====================================== Sedan's objects creation ====================================================
        Sedan bmw3Series = new Sedan("Sedan", "BMW 3 series", "Automatic", 8.00,
                40250, 5, 2013);
        Sedan bmw4Series = new Sedan("Sedan", "BMW 4 Series Gran Coupe", "Automatic",
                8.71, 43300, 5, 2015);
        Sedan jaguar = new Sedan("Sedan", "Jaguar X-Type", "Automatic", 13.07,
                35060, 5, 2008);
        Sedan mercedesBenzC43 = new Sedan("Sedan", "Mercedes-Benz C43", "Manual",
                12.0, 10000, 5, 2010);

// ====================================== Cabriolet's objects creation ================================================
        Cabriolet audiA3Automatic = new Cabriolet("Cabriolet", "Audi A3 Convertible", "Automatic",
                9.41, 38250, 4, 2018, false);
        Cabriolet audiA3Manual = new Cabriolet("Cabriolet", "Audi A3 Convertible", "Manual",
                9.41, 35300, 4, 2018, true);

// ====================================== Crossover's objects creation ================================================
        Crossover jeepPatriot = new Crossover("Crossover", "Jeep Patriot 4dr", "Automatic",
                10.69, 25840, 5, 2017);
        Crossover vwTiguan = new Crossover("Crossover", "Volkswagen Tiguan Limited 4dr", "Manual",
                11, 21995, 5, 2017);

// ====================================== Truck's objects creation =====================================================
        Truck chevroletColorado15 = new Truck("Truck", "Chevrolet Colorado Crew Cab Pickup",
                "Automatic", 12.38, 35780, 5, 2015);
        Truck chevroletColorado16 = new Truck("Truck", "Chevrolet Colorado Crew Cab Pickup",
                "Automatic", 12.38, 35780, 5, 2016);

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

// ===================================== Print all cars in the Taxi Station ==========================================
        taxiStationOperations.printAllCars(taxiStation);

// ==================================== Calculate cost of all cars of the Taxi Station ===============================
        taxiStationOperations.calculateCost(taxiStation);

// ================================ Search a car by parameters in the Taxi Station ===================================
        taxiStationOperations.searchCarByParameters(taxiStation, scan);

// ============================== Sort cars of the Taxi Station by fuel consumption ==================================
        Collections.sort(taxiStation, new FuelConsumptionComparator());
        System.out.println("\nOrder of cars in the Taxi Station on fuel consumption:");
        int count = 0;
        for (Vehicle car : taxiStation) {
            System.out.println(++count + ". {" + car.getType() + "}" + "{\"" + car.getModel() + "\"}" +
                    "{" + car.getLitresPerHudredKm() + " lpk}");
        }

    }
}
